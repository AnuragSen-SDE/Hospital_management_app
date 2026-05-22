package com.learnng.HospitalManagement.prescription.mapper;

import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionMedicineDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrescriptionMedicineMapper {
    PrescriptionMedicine toEntity(PrescriptionMedicineDto prescriptionMedicineDto);

    @Mapping(source = "prescription.id",target = "prescriptionId")
    PrescriptionMedicineDto toDto(PrescriptionMedicine prescriptionMedicine);
}
