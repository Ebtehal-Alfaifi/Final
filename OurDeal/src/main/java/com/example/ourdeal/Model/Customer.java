package com.example.ourdeal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @Column(columnDefinition = "int not null default 0")
    private Integer point;



    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
    private CustomerProfile customerProfile;

}
