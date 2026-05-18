package com.learnng.HospitalManagement.doctor.mapper;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.dto.DoctorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toDoctorEntity(DoctorDto doctorDto);
    DoctorDto toDoctorDto(Doctor doctor);
}
