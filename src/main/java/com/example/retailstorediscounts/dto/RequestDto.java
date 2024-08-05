package com.example.retailstorediscounts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    private Long userId;
    private double billAmount;
    private double groceriesBillAmount;

}
