package com.learnng.HospitalManagement.insurance.entiy.dto;

import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class InsuranceDto {

    private Long id;

    @NotBlank
    private String providerName;

    @NotBlank
    private String policyNumber;

    @NotNull
    private LocalDate expiryDate;

    @NotNull
    private Long patientId;

}
