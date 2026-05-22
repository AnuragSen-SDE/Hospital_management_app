package com.learnng.HospitalManagement.insurance.mapper;

import com.learnng.HospitalManagement.insurance.entiy.Insurance;
import com.learnng.HospitalManagement.insurance.entiy.dto.InsuranceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    @Mapping(target = "patient", ignore = true)
    Insurance toInsuranceEntity(InsuranceDto insuranceDto);

    @Mapping(source = "patient.id",target = "patientId")
    InsuranceDto toInsuranceDto(Insurance insurance);

}
