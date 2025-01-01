package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.DTOin.CustomerProfileDto;
import com.example.ourdeal.DTOin.VendorProfileDto;
import com.example.ourdeal.Model.Customer;
import com.example.ourdeal.Model.CustomerProfile;
import com.example.ourdeal.Model.Vendor;
import com.example.ourdeal.Model.VendorProfile;
import com.example.ourdeal.Repository.CustomerProfileRepository;
import com.example.ourdeal.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@AllArgsConstructor
//public class CustomerProfileService {
//    private final CustomerRepository customerRepository;
//    private final CustomerProfileRepository customerProfileRepository;
//
//    public List<CustomerProfile> getAll(){
//        return customerProfileRepository.findAll();
//    }


//    public void creatProfile( CustomerProfileDto customerProfileDto){
//
//        Customer customer=customerRepository.findCustomerById(customerProfileDto.getId());
//        if (customer==null){
//            throw new ApiException("customer not found");
//        }
//
//        CustomerProfile customerProfile = new CustomerProfile();
//        customerProfile.setId(customerProfileDto.getId());
//        customerProfile.getCustomer().getCustomerProfile();

