package com.example.ourdeal.Repository;

import com.example.ourdeal.Model.VendorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorProfileRepository extends JpaRepository<VendorProfile,Integer> {

    VendorProfile findByVendorId(Integer vendorId);

    List<VendorProfile>findVendorProfileByCity(String city);

}
