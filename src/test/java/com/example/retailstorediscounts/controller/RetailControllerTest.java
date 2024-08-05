package com.example.retailstorediscounts.controller;

import com.example.retailstorediscounts.dto.RequestDto;
import com.example.retailstorediscounts.services.RetailDiscountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@PropertySource("classpath:application.testcase.properties")
@EnableConfigurationProperties
@ContextConfiguration(classes = {RetailController.class})
@WebMvcTest(RetailController.class)
public class RetailControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RetailDiscountService retailDiscountService;
    @Autowired
    private RetailController retailController;

    @Test
    void testCalculateDiscount() throws Exception {
        // Prepare test data
        RequestDto requestDto = new RequestDto();
        requestDto.setGroceriesBillAmount(100);
        requestDto.setBillAmount(990.0);

        // Define the behavior of the mock service
        when(retailDiscountService.calculateDiscount(any(RequestDto.class))).thenReturn(75.0);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/api/discount/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(75.0));
    }
}