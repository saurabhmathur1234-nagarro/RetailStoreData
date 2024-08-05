package com.example.retailstorediscounts.controller;

import com.example.retailstorediscounts.dto.RequestDto;
import com.example.retailstorediscounts.services.RetailDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount")
public class RetailController {

    @Autowired
    private RetailDiscountService retailDiscountService;

    @PostMapping("/calculate")
    public double calculateDiscount(@RequestBody RequestDto request) {
        // Assuming we have a way to fetch User and Bill entities from database
        return retailDiscountService.calculateDiscount(request);
    }

}