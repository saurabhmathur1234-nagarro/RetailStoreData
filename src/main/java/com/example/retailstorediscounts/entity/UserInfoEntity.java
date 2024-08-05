package com.example.retailstorediscounts.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoEntity {
    private Long id;
    private String userType; // "employee", "affiliate", "customer"
    private int yearsAsCustomer;

    // Updated Constructor
    public UserInfoEntity(Long id, String userType, int yearsAsCustomer) {
        this.id = id;
        this.userType = userType;
        this.yearsAsCustomer = yearsAsCustomer;
    }

}
