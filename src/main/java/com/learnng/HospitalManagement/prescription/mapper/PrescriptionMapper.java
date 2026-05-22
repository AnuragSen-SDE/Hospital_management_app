package com.learnng.HospitalManagement.prescription.mapper;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

    Prescription toPrescriptionEntity(PrescriptionDto prescriptionDto);

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "patientId",source = "patient.id")
    @Mapping(target = "appointmentId",source = "appointment.id")
    PrescriptionDto toPrescriptionDto(Prescription prescription);
}
