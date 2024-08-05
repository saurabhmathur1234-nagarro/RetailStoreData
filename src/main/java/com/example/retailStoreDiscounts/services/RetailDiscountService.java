package com.example.retailStoreDiscounts.services;


import com.example.retailStoreDiscounts.dto.RequestDto;

public interface RetailDiscountService {
    double calculateDiscount(RequestDto request);
}
