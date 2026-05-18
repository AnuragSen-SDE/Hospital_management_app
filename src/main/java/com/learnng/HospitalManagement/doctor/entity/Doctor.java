package com.learnng.HospitalManagement.doctor.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String email;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = AvailableDays.class)
    private Set<AvailableDays> availableDays = new HashSet<>();
    private String roomNumber;

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<Appointment> appointments = new HashSet<>();

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    private Set<Prescription> prescriptions = new HashSet<>();
}
