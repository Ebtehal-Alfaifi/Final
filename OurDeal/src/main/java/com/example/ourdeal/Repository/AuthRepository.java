package com.example.ourdeal.Repository;

import com.example.ourdeal.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserByUsername(String userName);
    MyUser findMyUserById(Integer id);
}
