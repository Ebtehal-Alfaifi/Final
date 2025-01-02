package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.DTOin.VendorDto;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Model.Vendor;
import com.example.ourdeal.Repository.AuthRepository;
import com.example.ourdeal.Repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VendorService {


 private final AuthRepository authRepository;
 private final VendorRepository vendorRepository;





 //register for new vendor
    public void register(VendorDto vendorDto){
        MyUser myUser=authRepository.findMyUserByUsername(vendorDto.getUsername());
        if (myUser!=null){
            throw new ApiException(" user already exist");
        }
       // اتحقق اذا كان عنده سجل تجاري قبل تسجيله في الموقع
        if (vendorDto.getFoundationFile()!=true) {
            throw new ApiException("Company register is required to register as a vendor");
        }

        MyUser myUser1=new MyUser();
        myUser1.setName(vendorDto.getName());
        myUser1.setUsername(vendorDto.getUsername());
        myUser1.setEmail(vendorDto.getEmail());
        myUser1.setPassword(new BCryptPasswordEncoder().encode(vendorDto.getPassword()));
        myUser1.setRole("VENDOR");
        authRepository.save(myUser1);

        Vendor vendor=new Vendor();
        vendor.setFoundationFile(vendorDto.getFoundationFile());
        vendor.setCompanyRegister(vendorDto.getCompanyRegister());
        vendor.setMyUser(myUser1);

        vendorRepository.save(vendor);

    }


    public void updateVendore(Integer vendorId,VendorDto vendorDto ){

        MyUser oldUser=authRepository.findMyUserById(vendorId);
        if (oldUser==null){
            throw new ApiException(" vendor not found");
        }

        oldUser.setName(vendorDto.getName());
        oldUser.setUsername(vendorDto.getUsername());
        oldUser.setEmail(vendorDto.getEmail());
        oldUser.setPassword(new BCryptPasswordEncoder().encode(vendorDto.getPassword()));
        oldUser.getVendor().setFoundationFile(vendorDto.getFoundationFile());
        oldUser.getVendor().setCompanyRegister(vendorDto.getCompanyRegister());

        authRepository.save(oldUser);


    }


  public void deleteMyAccount(Integer vendorId){
        MyUser vendor=authRepository.findMyUserById(vendorId);
        if (vendor==null){
            throw new ApiException(" can not found this account");
        }
        authRepository.delete(vendor);
  }




  //end point to get all product that has a less than 5


    //send notification if stock has 0 product


}
