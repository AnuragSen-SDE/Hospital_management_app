package com.learnng.HospitalManagement.prescription.mapper;

import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionMedicineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionMedicineMapper {
    PrescriptionMedicine toEntity(PrescriptionMedicineDto prescriptionMedicineDto);

    PrescriptionMedicineDto toDto(PrescriptionMedicine prescriptionMedicine);
}
