package com.learnng.HospitalManagement.appointment.mapper;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toAppointment(AppointmentDto appointmentDto);
    AppointmentDto toAppointmentDto(Appointment appointment);
}
