package com.learnng.HospitalManagement.insurance.entiy;

import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String providerName;

    @Column(nullable = false,length = 20)
    private String policyNumber;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @OneToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

}
