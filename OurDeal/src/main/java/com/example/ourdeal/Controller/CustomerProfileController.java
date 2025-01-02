package com.example.ourdeal.Controller;

import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Service.CustomerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer-profile")
@RequiredArgsConstructor
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;


    @GetMapping("/get-my-profile")
    public ResponseEntity getMyAccounts(@AuthenticationPrincipal MyUser myUser) {
        return ResponseEntity.status(200).body(customerProfileService.getAll());
    }






}
