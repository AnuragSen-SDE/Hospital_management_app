package com.learnng.HospitalManagement.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String specialization;
    private String qualification;
    private String yearsOfExperience;
    private String phoneNumber;
    private String availableDays;
    private String roomNumber;
}


/*
id
fullName
specialization
qualification
yearsOfExperience
consultationFee
phoneNumber
email
availableDays
roomNumber
 */