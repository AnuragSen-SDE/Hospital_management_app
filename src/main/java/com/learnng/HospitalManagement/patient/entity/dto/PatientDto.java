package com.learnng.HospitalManagement.patient.entity.dto;

import com.learnng.HospitalManagement.patient.entity.type.BloodGroup;
import com.learnng.HospitalManagement.patient.entity.type.GenderType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class PatientDto {

    @Size(min = 0,max = 50)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String fullName;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer age;

    @NotBlank
    @Email
    private String email;

    @Past
    private LocalDate birthDate;

    @NotNull
    private GenderType gender;

    @NotNull
    private BloodGroup bloodGroup;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private String emergencyContact;
}

/*
id
fullName
age
birthDate
gender
bloodGroup
 */
