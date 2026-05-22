package com.learnng.HospitalManagement.medicine.repository;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
