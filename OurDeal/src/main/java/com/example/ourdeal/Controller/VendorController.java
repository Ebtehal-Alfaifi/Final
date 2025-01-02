package com.example.ourdeal.Controller;

import com.example.ourdeal.Api.ApiResponse;
import com.example.ourdeal.DTOin.CustomerDto;
import com.example.ourdeal.DTOin.VendorDto;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Service.CustomerService;
import com.example.ourdeal.Service.VendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid VendorDto vendorDto) {
        vendorService.register(vendorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Customer register successful"));
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@AuthenticationPrincipal MyUser myUser,
                                         @PathVariable Integer customerId,
                                         @RequestBody @Valid VendorDto vendorDto) {
        vendorService.updateVendore( customerId, vendorDto);
        return ResponseEntity.status(200).body(new ApiResponse("Customer with ID: " + customerId + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity deleteCustomer(@AuthenticationPrincipal MyUser myUser,
                                         @PathVariable Integer vendorId) {
        vendorService.deleteMyAccount(vendorId);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted successful"));
    }



}
