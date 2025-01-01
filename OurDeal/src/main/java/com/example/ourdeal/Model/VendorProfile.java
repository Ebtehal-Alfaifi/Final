package com.example.ourdeal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VendorProfile {


    @Id
    private int id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @Column(columnDefinition = "varchar(10) not null")
    private String city;

    @Column(columnDefinition = "boolean not null ")
    private Boolean foundationFile;


    @Column(columnDefinition = "varchar not null")
    private String companyRegister;



    @OneToOne
    @MapsId
    @JsonIgnore
    private Vendor vendor;

}
