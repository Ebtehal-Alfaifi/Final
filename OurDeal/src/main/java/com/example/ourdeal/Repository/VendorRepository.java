package com.example.ourdeal.Repository;

import com.example.ourdeal.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer>{
Vendor findVendorById(Integer id);
}
