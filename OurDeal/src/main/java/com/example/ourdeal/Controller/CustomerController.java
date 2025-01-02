package com.example.ourdeal.Controller;

import com.example.ourdeal.Api.ApiResponse;
import com.example.ourdeal.DTOin.CustomerDto;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerDto customerDTO) {
        customerService.register(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Customer register successful"));
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@AuthenticationPrincipal MyUser myUser,
                                         @PathVariable Integer customerId,
                                         @RequestBody @Valid CustomerDto customerDTO) {
        customerService.updateCustomer( customerId, customerDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Customer with ID: " + customerId + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity deleteCustomer(@AuthenticationPrincipal MyUser myUser,
                                         @PathVariable Integer customerId) {
        customerService.deleteMyAccount(customerId);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted successful"));
    }



}
