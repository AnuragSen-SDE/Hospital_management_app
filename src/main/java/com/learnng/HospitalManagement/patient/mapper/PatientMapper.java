package com.learnng.HospitalManagement.patient.mapper;

import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.entity.dto.PatientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    public Patient toPatientEntity(PatientDto patientDto);
    PatientDto toPatientDto(Patient patient);
}
