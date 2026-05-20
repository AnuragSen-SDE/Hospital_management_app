package com.learnng.HospitalManagement.prescription.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PrescriptionMedicineDto {

    @NotBlank
    private String medicineName;

    @NotBlank
    private String dosage;

    @NotBlank
    private String frequency;

    @NotBlank
    private String duration;

    private String instruction;
}