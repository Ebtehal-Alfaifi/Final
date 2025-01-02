package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.DTOin.VendorProfileDto;
import com.example.ourdeal.DTOout.VendorProfileDtoOut;
import com.example.ourdeal.Model.Vendor;
import com.example.ourdeal.Model.VendorProfile;
import com.example.ourdeal.Repository.AuthRepository;
import com.example.ourdeal.Repository.VendorProfileRepository;
import com.example.ourdeal.Repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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













    //endPoint get vendor by city
    public List<VendorProfileDtoOut> getVendorByCity(String city) {
        List<VendorProfile> vendorProfiles = vendorProfileRepository.findVendorProfileByCity(city);
        if (vendorProfiles == null || vendorProfiles.isEmpty()) {
            throw new ApiException("There is no vendor in that city");
        }

        List<VendorProfileDtoOut> vendorProfileDtos = new ArrayList();
        for (VendorProfile vendorProfile : vendorProfiles) {
            VendorProfileDtoOut dto = new VendorProfileDtoOut();
            dto.setName(vendorProfile.getName());
            dto.setPhoneNumber(vendorProfile.getPhoneNumber());
            vendorProfileDtos.add(dto);
        }

        return vendorProfileDtos;
    }




}
