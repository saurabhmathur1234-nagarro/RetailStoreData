package com.example.retailStoreDiscounts.services.impl;

import com.example.retailStoreDiscounts.dto.RequestDto;
import com.example.retailStoreDiscounts.services.RetailDiscountService;
import org.springframework.stereotype.Service;

@Service
public class RetailDiscountServiceImpl implements RetailDiscountService {

    @Override
    public double calculateDiscount(RequestDto request) {
        double discount;

        if (request.getIsGroceries().equals("true")) {
            return request.getBillAmount();
        }

        // Determine percentage discount
        double percentageDiscount = getPercentageDiscount(request);
        discount = request.getBillAmount() * percentageDiscount / 100;

        // Apply flat discount
        discount += calculateFlatDiscount(request.getBillAmount());
        return request.getBillAmount() - discount;
    }

    private double getPercentageDiscount(RequestDto request) {
        if ("employee".equals(request.getUserType())) {
            return 30.0;
        } else if ("affiliate".equals(request.getUserType())) {
            return 10.0;
        } else if ("customer".equals(request.getUserType()) && request.getYearsAsCustomer() > 2) {
            return 5.0;
        }
        return 0.0;
    }

    private double calculateFlatDiscount(double amount) {
        int numberOfHundreds = (int) (amount / 100);
        return numberOfHundreds * 5;
    }
}