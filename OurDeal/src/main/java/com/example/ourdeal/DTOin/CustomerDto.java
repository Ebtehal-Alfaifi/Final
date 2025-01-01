package com.example.ourdeal.DTOin;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CustomerDto {

    private Integer Id;

    @NotEmpty(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = " Name can not be less than 2 and more than 20 characters")
    private String name;


    @NotEmpty(message = "Username cannot be null")
    @Size(min = 3, max = 10, message = "Username can not be less than 3 and  more than 10 characters")
    private String username;

    @NotEmpty(message = "User Email cannot be null")
    @Email(message = "you should enter Valid email")
    @Size(max = 30,message = "email character can not be more than 30")
    private String email;

    @NotEmpty(message = " Password cannot be null")
    @Size(min = 8, max = 300, message = " Password must be at least 8 characters")
    private String password;

    @NotEmpty(message = "phone number can not be null")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be followed by 8 digits")
    private String phoneNumber;



}
