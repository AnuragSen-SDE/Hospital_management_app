package com.learnng.HospitalManagement.doctor.entity.dto;

import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
public class DoctorDto {

    private Long id;

    @NotBlank
    @Size(max = 40)
    @Pattern(regexp = "^[a-zA-z ]+$",message = "Name must contain only letters and spaces")
    private String fullName;

    @NotBlank
    private String specialization;

    @NotBlank
    private String qualification;

    @NotBlank
    private String yearsOfExperience;

    @NotBlank
    @Size(min = 10 ,max = 13)
    @Pattern(regexp = "^(\\+91)?[6-9]\\d{9}$" ,message = "Invalid phone number")
    private String phoneNumber;

    @Email(message = "Invalid email")
    @NotBlank
    private String email;


    @NotEmpty(message = "Available Days Can't be empty")
    private Set<AvailableDays> availableDays;

    @NotBlank
    @Pattern(regexp = "^[A-Z][0-9]{3}$", message = "Invalid Room number")
    private String roomNumber;

}
