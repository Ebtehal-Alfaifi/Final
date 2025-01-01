package com.example.ourdeal.DTOin;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CustomerProfileDto {

    private Integer id;


    @NotEmpty(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = " Name can not be less than 2 and more than 20 characters")
    private String name;

    @NotEmpty(message = "Phone Number can not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be followed by 8 digits")
    private String phoneNumber;

    @NotEmpty(message = " city can not be null")
    @Size(min = 3, max = 10, message = " city name can not be less than 3 or more than 10")
    private String city;


    @NotEmpty(message = "street can not be null")
    @Size(min = 3,max = 10,message ="Street name can not be less than 3 or more than 10" )
    private String street;

    @NotEmpty(message = "street can not be null")
    @Size(min = 3,max = 10,message ="Street name can not be less than 3 or more than 10" )
    private String district;





}
