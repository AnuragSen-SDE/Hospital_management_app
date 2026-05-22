package com.learnng.HospitalManagement.prescription.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddMedicineRequest {

    @NotNull
    private Long medicineId;

    @NotNull
    private Integer quantity;

    @NotBlank
    private String dosages;

    @NotBlank
    private String frequency;

    @NotBlank
    private String durationInDays;

}
