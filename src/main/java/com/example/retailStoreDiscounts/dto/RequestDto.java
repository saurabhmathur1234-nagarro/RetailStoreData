package com.example.retailStoreDiscounts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    private String userType;
    private String isGroceries;
    private double billAmount;
    private int yearsAsCustomer;

}
