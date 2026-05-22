package com.learnng.HospitalManagement.medicine.entity.dto;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MedicineDto {

    private Long id;

    @NotBlank
    private String medicineName;

    @NotNull
    private Double unitPrice;

    private String manufacturer;

    private Integer stockQuantity;

}
