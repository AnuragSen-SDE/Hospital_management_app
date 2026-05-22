package com.learnng.HospitalManagement.prescription.entity.dto;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.medicine.entity.dto.MedicineDto;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PrescriptionMedicineDto {

    private Long id;

    private MedicineDto medicine;

    @NotNull
    private Long prescriptionId;

    private Integer quantity;

    @NotBlank
    private String dosage;

    @NotBlank
    private String frequency;

    @NotBlank
    private String durationInDays;

    @NotNull
    private Double unitPrice;
}