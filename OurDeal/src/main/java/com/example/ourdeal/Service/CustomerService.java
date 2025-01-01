package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.DTOin.CustomerDto;
import com.example.ourdeal.DTOin.VendorDto;
import com.example.ourdeal.Model.Customer;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Model.Vendor;
import com.example.ourdeal.Repository.AuthRepository;
import com.example.ourdeal.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

  private final AuthRepository authRepository;
  private final CustomerRepository customerRepository;




    //register for new vendor
    public void register(CustomerDto customerDto){
        MyUser myUser=authRepository.findMyUserByUsername(customerDto.getUsername());
        if (myUser!=null){
            throw new ApiException(" user already exist");
        }

        MyUser myUser1=new MyUser();
        myUser1.setName(customerDto.getName());
        myUser1.setUsername(customerDto.getUsername());
        myUser1.setEmail(customerDto.getEmail());
        myUser1.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        myUser1.setRole("CUSTOMER");
        authRepository.save(myUser1);

        Customer customer=new Customer();
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setMyUser(myUser1);
        customerRepository.save(customer);

    }


    public void updateVendore(Integer customerId,CustomerDto customerDto ){

        MyUser oldUser=authRepository.findMyUserById(customerId);
        if (oldUser==null){
            throw new ApiException(" customer not found");
        }

        oldUser.setName(customerDto.getName());
        oldUser.setUsername(customerDto.getUsername());
        oldUser.setEmail(customerDto.getEmail());
        oldUser.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        oldUser.getCustomer().setPhoneNumber(customerDto.getPhoneNumber());

        authRepository.save(oldUser);


    }


    public void deleteMyAccount(Integer customerId){
        MyUser vendor=authRepository.findMyUserById(customerId);
        if (vendor==null){
            throw new ApiException(" can not found this account");
        }
        authRepository.delete(vendor);
    }




}
