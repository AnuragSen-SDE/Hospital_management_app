package com.learnng.HospitalManagement.patient.entity;

import com.learnng.HospitalManagement.patient.entity.type.BloodGroup;
import com.learnng.HospitalManagement.patient.entity.type.GenderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",nullable = false,length = 100)
    private String fullName;

    @Column(name = "age",nullable = false)
    @Min(0)
    @Max(120)
    private Integer age;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column(name = "blood_group")
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @Column(name = "phone_number")
    @Size(min = 10,max = 12)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "emergency_contact_number")
    private String emergencyContact;

    private LocalDate birthDate;
}
