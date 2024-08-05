package com.example.retailstorediscounts.services;

import com.example.retailstorediscounts.dto.RequestDto;
import com.example.retailstorediscounts.services.impl.RetailDiscountServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetailDiscountServiceImplTest {
    private final RetailDiscountServiceImpl retailDiscountService = new RetailDiscountServiceImpl();

    @Test
    void testCalculateDiscountForEmployee() {
        RequestDto request = new RequestDto();
        request.setUserId(1L);
        request.setGroceriesBillAmount(100);
        request.setBillAmount(990.0);

        double expectedDiscount = 743;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForAffiliate() {
        RequestDto request = new RequestDto();
        request.setUserId(2L);
        request.setGroceriesBillAmount(200);
        request.setBillAmount(150.0);

        double expectedDiscount = 320;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForOldCustomer() {
        RequestDto request = new RequestDto();
        request.setUserId(3L);
        request.setGroceriesBillAmount(300);
        request.setBillAmount(720);

        double expectedDiscount = 934;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForGroceries() {
        RequestDto request = new RequestDto();
        request.setUserId(4L);
        request.setGroceriesBillAmount(100);
        request.setBillAmount(500.0);

        double expectedDiscount = 420; // No discount for groceries
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }
}