package com.example.retailStoreDiscounts.services;

import com.example.retailStoreDiscounts.dto.RequestDto;
import com.example.retailStoreDiscounts.services.impl.RetailDiscountServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetailDiscountServiceImplTest {
    private final RetailDiscountServiceImpl retailDiscountService = new RetailDiscountServiceImpl();

    @Test
    void testCalculateDiscountForEmployee() {
        RequestDto request = new RequestDto();
        request.setUserType("employee");
        request.setIsGroceries("false");
        request.setBillAmount(990.0);
        request.setYearsAsCustomer(1);

        double expectedDiscount = 648.0;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForAffiliate() {
        RequestDto request = new RequestDto();
        request.setUserType("affiliate");
        request.setIsGroceries("false");
        request.setBillAmount(150.0);
        request.setYearsAsCustomer(1);

        double expectedDiscount = 130.0;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForOldCustomer() {
        RequestDto request = new RequestDto();
        request.setUserType("customer");
        request.setIsGroceries("false");
        request.setBillAmount(200.0);
        request.setYearsAsCustomer(3);

        double expectedDiscount = 200.0 - (200.0 * 5.0 / 100) - (200.0 / 100) * 5;
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }

    @Test
    void testCalculateDiscountForGroceries() {
        RequestDto request = new RequestDto();
        request.setUserType("employee");
        request.setIsGroceries("true");
        request.setBillAmount(500.0);
        request.setYearsAsCustomer(1);

        double expectedDiscount = 500.0; // No discount for groceries
        double actualDiscount = retailDiscountService.calculateDiscount(request);

        assertEquals(expectedDiscount, actualDiscount, 0.01);
    }
}