package com.learnng.HospitalManagement.medicine.service;

import com.learnng.HospitalManagement.medicine.entity.Medicine;

public interface MedicineService {
    Medicine registerMedicine( Medicine medicine);
    Medicine findMedicineById( Long id);
    Medicine saveMedicine(Medicine medicine);
}
