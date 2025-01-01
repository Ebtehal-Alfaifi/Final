package com.example.ourdeal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Vendor {
    @Id
    private Integer id;


    @Column(columnDefinition = "boolean not null")
    private Boolean foundationFile;



    @Column(columnDefinition = "varchar(10) not null")
    private String companyRegister;


    @AssertFalse
    @Column(columnDefinition = "boolean default false not null")
    private boolean status;


    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "vendor")
    private VendorProfile vendorProfile;


}
