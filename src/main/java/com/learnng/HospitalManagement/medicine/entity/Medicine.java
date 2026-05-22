package com.learnng.HospitalManagement.medicine.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "medicine_master_data")
@Getter
@Setter
@Builder
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String medicineName;

    @Column(nullable = false)
    private Double unitPrice;

    private String manufacturer;

    private Integer stockQuantity;

}
