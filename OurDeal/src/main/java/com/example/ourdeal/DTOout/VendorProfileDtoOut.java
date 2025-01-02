package com.example.ourdeal.DTOout;

import lombok.AllArgsConstructor;
import lombok.Data;


//that dto is for get vendor by there city

@Data
@AllArgsConstructor
public class VendorProfileDtoOut {

    private String name;

    private String phoneNumber;

    public VendorProfileDtoOut(){}

}
