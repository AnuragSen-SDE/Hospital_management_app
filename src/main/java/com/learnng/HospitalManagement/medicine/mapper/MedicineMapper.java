package com.learnng.HospitalManagement.medicine.mapper;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.medicine.entity.dto.MedicineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicineMapper {
    Medicine toEntity(MedicineDto medicineDto);
    MedicineDto toDto(Medicine medicine);
}
