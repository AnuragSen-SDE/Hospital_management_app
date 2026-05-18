package com.learnng.HospitalManagement.appointment.service;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDto appointmentDto);
}
