package com.learnng.HospitalManagement.appointment.controller;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;
import com.learnng.HospitalManagement.appointment.mapper.AppointmentMapper;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    @PreAuthorize("hasAuthority('APPOINTMENT_CREATE')")
    public ResponseEntity<ApiResponse> createAppointment(
            @Valid @RequestBody AppointmentDto appointmentDto
            ) {
        AppointmentDto response = appointmentMapper.toAppointmentDto( appointmentService.createAppointment(appointmentDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Appointment Created Successfully")
                                .data(response)
                                .build()
                );
    }

    @PutMapping("/{id}/{status}")
    @PreAuthorize("hasAuthority('APPOINTMENT_UPDATE')")
    public ResponseEntity<ApiResponse> updateAppointmentState(
            @PathVariable(name = "id") Long appointmentId ,
            @PathVariable(name = "status")AppointmentStatus status
            ) {
        appointmentService.updateAppointmentStatus(appointmentId,status);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data("Appointment Status update successfully")
                        .build()
        );
    }

}
