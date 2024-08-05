package com.example.retailStoreDiscounts.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserInfoEntity {
    private Long id;
    private String userType; // "employee", "affiliate", "customer"
    private boolean isGroceries; // true if the user is buying groceries
    private int yearsAsCustomer;
}
