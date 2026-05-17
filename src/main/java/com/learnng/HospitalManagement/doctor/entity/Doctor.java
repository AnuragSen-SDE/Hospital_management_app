package com.learnng.HospitalManagement.doctor.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<Appointment> appointments;
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