package com.example.ourdeal.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class CustomerProfile {

    @Id
    private  int id;

    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = " city can not be null")
    @Size(min = 3, max = 10, message = " city name can not be less than 3 or more than 10")
      private String city;


 @Column(columnDefinition = "varchar(10) not null")
 @NotEmpty(message = "street can not be null")
 @Size(min = 3,max = 10,message ="Street name can not be less than 3 or more than 10" )
    private String street;

    @Column(columnDefinition ="varchar(10) not null" )
    @NotEmpty(message = "street can not be null")
    @Size(min = 3,max = 10,message ="Street name can not be less than 3 or more than 10" )
    private String district;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;



}
