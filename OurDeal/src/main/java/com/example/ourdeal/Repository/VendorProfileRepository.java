package com.example.ourdeal.Repository;

import com.example.ourdeal.Model.VendorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorProfileRepository extends JpaRepository<VendorProfile,Integer> {

    VendorProfile findByVendorId(Integer vendorId);

}
