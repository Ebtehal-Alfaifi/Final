package com.example.ourdeal.DTOin;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendorDto {


    private Integer Id;

    @NotEmpty(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = " Name can not be less than 2 and more than 20 characters")
    private String name;


    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3, max = 10, message = "Username can not be less than 3 and  more than 10 characters")
    private String username;

    @NotEmpty(message = "User Email cannot be null")
    @Email(message = "you should enter Valid email")
    @Size(max = 30,message = "email character can not be more than 30")
    private String email;

    @NotEmpty(message = " Password cannot be null")
    @Size(min = 8, max = 300, message = " Password must be at least 8 characters")
    private String password;



    @NotNull(message = "Vendor Foundation File cannot be empty")
    private Boolean foundationFile;



    @NotEmpty(message = "Vendor Company Register Number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Vendor Company Register Number must contain exactly 10 digits")
    private String companyRegister;

}
