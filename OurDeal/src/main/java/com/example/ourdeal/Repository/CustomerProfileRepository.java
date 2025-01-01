package com.example.ourdeal.Repository;

import com.example.ourdeal.Model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile,Integer> {
    CustomerProfile findCustomerProfileById(Integer id);
}
