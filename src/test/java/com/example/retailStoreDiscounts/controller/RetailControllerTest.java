//package com.example.retailStoreDiscounts.controller;
//
//import com.example.retailStoreDiscounts.dto.RequestDto;
//import com.example.retailStoreDiscounts.services.RetailDiscountService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@PropertySource("classpath:application-testcase.properties")
//@EnableConfigurationProperties
//@ContextConfiguration(classes = {RetailController.class})
//@WebMvcTest(RetailController.class)
//public class RetailControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private RetailDiscountService retailDiscountService;
//    @Autowired
//    private RetailController retailController;
//    @MockBean
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testCalculateDiscount() throws Exception {
//        // Prepare test data
//        RequestDto requestDto = new RequestDto();
//        requestDto.setUserType("employee");
//        requestDto.setIsGroceries("false");
//        requestDto.setBillAmount(990.0);
//        requestDto.setYearsAsCustomer(3);
//
//        // Define the behavior of the mock service
//        when(retailDiscountService.calculateDiscount(any(RequestDto.class))).thenReturn(75.0);
//
//        // Perform the POST request and verify the response
//        mockMvc.perform(post("/api/discount/calculate")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(requestDto)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value(75.0));
//    }
//}