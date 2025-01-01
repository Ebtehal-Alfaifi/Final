package com.example.ourdeal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class MyUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "User Name cannot be null")
    @Size(min = 2, max = 20, message = " Name can not be less than 2 and more than 20 characters")
    private String name;


    @Column(columnDefinition = "varchar(10) not null unique")
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3, max = 10, message = "Username can not be less than 3 and  more than 10 characters")
    private String username;



    @NotEmpty(message = "User Email cannot be null")
    @Column(columnDefinition = "varchar(30) not null unique")
    @Email(message = "you should enter Valid email")
    @Size(max = 30,message = "email character can not be more than 30")
    private String email;

    @Column(columnDefinition = "varchar(300) not null")
    @NotEmpty(message = " Password cannot be null")
    @Size(min = 8, max = 300, message = " Password must be at least 8 characters")
    private String password;

    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp = "^(VENDOR|CUSTOMER|ADMIN)$",
       message = "User Role must be either 'VENDOR', 'CUSTOMER', or 'ADMIN' only")
    private String role;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    private Vendor vendor;


   @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    private Customer customer;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
