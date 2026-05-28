package com.learnng.HospitalManagement.doctor.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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

    @Column(nullable = false)
    private String fullName;
    private String specialization;
    private String qualification;
    private String yearsOfExperience;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
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

    @OneToMany(
            cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "doctor"
    )
    private Set<Billing> bills = new HashSet<>();

    @Column(nullable = false)
    @Min(0)
    private Double consultationFee;

    @OneToOne(
            cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.MERGE,CascadeType.PERSIST},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private User user;
}
