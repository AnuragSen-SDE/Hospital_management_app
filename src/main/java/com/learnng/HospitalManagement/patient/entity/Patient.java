package com.learnng.HospitalManagement.patient.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.insurance.entiy.Insurance;
import com.learnng.HospitalManagement.patient.entity.type.BloodGroup;
import com.learnng.HospitalManagement.patient.entity.type.GenderType;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity()
@ToString
@Getter
@Setter
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

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "patient"
    )
    @ToString.Exclude
    private final Set<Address> address = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "patient"
    )
    @ToString.Exclude
    private final Set<Appointment> appointments = new HashSet<>();

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "patient"
    )
    @ToString.Exclude
    private  Insurance insurance;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<Prescription> prescriptions = new HashSet<>();

    @Column(name = "emergency_contact_number")
    private String emergencyContact;

    private LocalDate birthDate;
}
