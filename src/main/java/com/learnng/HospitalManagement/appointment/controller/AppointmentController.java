package com.learnng.HospitalManagement.appointment.controller;

import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ApiResponse> createAppointment(
            @Valid @RequestBody AppointmentDto appointmentDto
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Appointment Created Successfully")
                                .data(appointmentService.createAppointment(appointmentDto))
                                .build()
                );
    }

}
