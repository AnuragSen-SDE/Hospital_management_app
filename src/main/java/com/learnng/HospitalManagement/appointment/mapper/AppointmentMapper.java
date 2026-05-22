package com.learnng.HospitalManagement.appointment.mapper;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient",ignore = true)
    Appointment toAppointment(AppointmentDto appointmentDto);

    @Mapping(target = "doctorId",source = "doctor.id")
    @Mapping(source = "patient.id",target = "patientId")
    AppointmentDto toAppointmentDto(Appointment appointment);
}
