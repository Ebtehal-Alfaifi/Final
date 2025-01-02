package com.example.ourdeal.Controller;

import com.example.ourdeal.Api.ApiResponse;
import com.example.ourdeal.DTOin.VendorProfileDto;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Service.VendorProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendor/profile")
@RequiredArgsConstructor
public class VendorProfileController {

   private final VendorProfileService vendorProfileService;


    @GetMapping("/get-my-profile")
    public ResponseEntity getMyAccounts(@AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(200).body(vendorProfileService.getAll());
    }


    @PostMapping("/create/vendor-profile")
    public ResponseEntity createProfile(@AuthenticationPrincipal MyUser myUser,
                                        @RequestBody @Valid VendorProfileDto vendorProfileDto) {

        vendorProfileService.creatProfile(vendorProfileDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Vendor profile created successfully"));


    }


    @PutMapping("/update/{vendorId}")
    public ResponseEntity updateVendorProfile(@AuthenticationPrincipal MyUser myUser,
                                              @PathVariable Integer vendorId,
                                              @RequestBody @Valid VendorProfileDto vendorProfileDto) {

            vendorProfileService.updateVendorProfile(vendorId, vendorProfileDto);


            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Vendor profile updated successfully"));

}}
