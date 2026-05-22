package com.learnng.HospitalManagement.prescription.entity;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Prescription prescription;

    private Integer quantity;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private String frequency;

    @Column(nullable = false)
    private String durationInDays;

    @Column(nullable = false)
    private Double unitPrice;
}
