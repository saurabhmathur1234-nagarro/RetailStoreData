package com.example.retailStoreDiscounts.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BillInfoEntity {

    private Long id;
    private double amount;
    private boolean isGroceries;
}
