package com.learnng.HospitalManagement.medicine.service.impl;

import com.learnng.HospitalManagement.exception.custom.AppointmentException;
import com.learnng.HospitalManagement.exception.custom.MedicineException;
import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.medicine.repository.MedicineRepository;
import com.learnng.HospitalManagement.medicine.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public Medicine registerMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine findMedicineById(Long id) {

        return medicineRepository.findById(id).orElseThrow(
                () -> new AppointmentException("Medicine Not found Exception")
        );
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Transactional
    @Override
    public Medicine addMedicineStock(Long medicineId, Integer quantity) {
        Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(
                () -> new MedicineException("Medicine Not found")
                );
        if (quantity <= 0 ) throw new MedicineException("Invalid Quantity");
        medicine.setStockQuantity(medicine.getStockQuantity()+ quantity);

        return medicineRepository.save(medicine);
    }
}
