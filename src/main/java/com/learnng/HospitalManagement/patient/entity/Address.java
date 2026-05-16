package com.learnng.HospitalManagement.patient.entity;

import jakarta.persistence.*;

@Entity(name = "address_table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String  state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String pinCode;

    @Column(nullable = false)
    private String postOffice;

    @Column(nullable = false)
    private String policeStation;


}
