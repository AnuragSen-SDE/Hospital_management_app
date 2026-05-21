package com.learnng.HospitalManagement.prescription.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class PrescriptionMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String medicineName;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private String frequency;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Double price;

    private String instruction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Prescription prescription;
}
