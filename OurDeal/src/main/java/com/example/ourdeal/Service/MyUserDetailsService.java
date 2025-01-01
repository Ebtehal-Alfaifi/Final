package com.example.ourdeal.Service;

import com.example.ourdeal.Api.ApiException;
import com.example.ourdeal.Model.MyUser;
import com.example.ourdeal.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class MyUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser=authRepository.findMyUserByUsername(username);
        if (myUser==null){
            throw new ApiException("wrong username or password");
        }
        return myUser;
    }
}
