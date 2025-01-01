package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.DTOin.VendorProfileDto;
import com.example.ourdeal.Model.Vendor;
import com.example.ourdeal.Model.VendorProfile;
import com.example.ourdeal.Repository.AuthRepository;
import com.example.ourdeal.Repository.VendorProfileRepository;
import com.example.ourdeal.Repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class VendorProfileService {
    private final VendorRepository vendorRepository;
    private final AuthRepository authRepository;
    private final VendorProfileRepository vendorProfileRepository;


    public List<VendorProfile>getAll(){
        return vendorProfileRepository.findAll();
    }


    public void creatProfile( VendorProfileDto vendorProfileDto){

        Vendor vendor=vendorRepository.findVendorById(vendorProfileDto.getId());
        if (vendor==null){
            throw new ApiException("vendor not found");
        }

        VendorProfile vendorProfile = new VendorProfile();
        vendorProfile.setId(vendorProfileDto.getId());
        vendorProfile.setName(vendorProfileDto.getName());
        vendorProfile.setPhoneNumber(vendorProfileDto.getPhoneNumber());
        vendorProfile.setCity(vendorProfileDto.getCity());
        vendorProfile.setCompanyRegister(vendorProfileDto.getCompanyRegister());
        vendorProfile.setVendor(vendor);

        vendorProfileRepository.save(vendorProfile);

    }


    public void updateVendorProfile(Integer vendorId, VendorProfileDto vendorProfileDto) {

        Vendor vendor = vendorRepository.findVendorById(vendorId);
        if (vendor == null) {
            throw new ApiException("Vendor not found");
        }

        VendorProfile vendorProfile = vendorProfileRepository.findByVendorId(vendorId);
        if (vendorProfile == null) {
            throw new ApiException("Vendor profile not found");
        }

        vendorProfile.setName(vendorProfileDto.getName());
        vendorProfile.setPhoneNumber(vendorProfileDto.getPhoneNumber());
        vendorProfile.setCity(vendorProfileDto.getCity());
        vendorProfile.setCompanyRegister(vendorProfileDto.getCompanyRegister());


        vendorProfileRepository.save(vendorProfile);
    }










}
