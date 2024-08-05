package com.example.retailstorediscounts.services.impl;

import com.example.retailstorediscounts.dto.RequestDto;
import com.example.retailstorediscounts.entity.UserInfoEntity;
import com.example.retailstorediscounts.services.RetailDiscountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetailDiscountServiceImpl implements RetailDiscountService {

    @Override
    public double calculateDiscount(RequestDto request) {

        UserInfoEntity userDetail = findUserById(request.getUserId());

        double discount;
        double totalBillAmount = request.getBillAmount() + request.getGroceriesBillAmount();
        // Determine percentage discount
        double percentageDiscount = getPercentageDiscount(userDetail);
        discount = request.getBillAmount() * percentageDiscount / 100;

        // Apply flat discount
        discount += calculateFlatDiscount(totalBillAmount);

        return totalBillAmount - discount;
    }

    private double getPercentageDiscount(UserInfoEntity userDetail) {
        if ("employee".equals(userDetail.getUserType())) {
            return 30.0;
        } else if ("affiliate".equals(userDetail.getUserType())) {
            return 10.0;
        } else if ("customer".equals(userDetail.getUserType()) && userDetail.getYearsAsCustomer() > 2) {
            return 5.0;
        }
        return 0.0;
    }

    private double calculateFlatDiscount(double amount) {
        int numberOfHundreds = (int) (amount / 100);
        return numberOfHundreds * 5;
    }

    //list of employees
    public List<UserInfoEntity> createUserList() {
        List<UserInfoEntity> users = new ArrayList<>();
        users.add(new UserInfoEntity(1L, "employee", 1));
        users.add(new UserInfoEntity(2L, "employee", 2));
        users.add(new UserInfoEntity(3L, "affiliate", 1));
        users.add(new UserInfoEntity(4L, "affiliate", 2));
        users.add(new UserInfoEntity(5L, "customer", 1));
        users.add(new UserInfoEntity(6L, "customer", 2));

        return users;
    }

    // Method to find a UserInfoEntity by id
    public UserInfoEntity findUserById(Long id) {
        return createUserList().stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst()
                .orElse(null);
    }
}