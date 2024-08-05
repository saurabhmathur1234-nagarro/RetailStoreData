package com.example.retailstorediscounts.services;


import com.example.retailstorediscounts.dto.RequestDto;

public interface RetailDiscountService {
    double calculateDiscount(RequestDto request);
}