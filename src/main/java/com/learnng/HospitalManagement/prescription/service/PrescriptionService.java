package com.learnng.HospitalManagement.prescription.service;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.entity.dto.AddMedicineRequest;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;

public interface PrescriptionService {
    Prescription registerPrescription(PrescriptionDto prescriptionDto);
    void addMedicine(Long prescriptionId, AddMedicineRequest addMedicineRequest);
    Prescription findPrescriptionById(Long prescriptionId);
}
