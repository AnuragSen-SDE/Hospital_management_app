package com.learnng.HospitalManagement.medicine.service.impl;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.medicine.repository.MedicineRepository;
import com.learnng.HospitalManagement.medicine.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public Medicine registerMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}
