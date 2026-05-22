package com.learnng.HospitalManagement.prescription.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.exception.custom.PrescriptionException;
import com.learnng.HospitalManagement.medicine.service.MedicineService;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;
import com.learnng.HospitalManagement.prescription.mapper.PrescriptionMapper;
import com.learnng.HospitalManagement.prescription.repository.PrescriptionRepository;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final MedicineService medicineService;

    @Transactional
    @Override
    public Prescription registerPrescription(PrescriptionDto prescriptionDto) {

        if (prescriptionRepository.existsByAppointmentId(prescriptionDto.getAppointmentId()))
            throw new PrescriptionException("The appointment already associated with a prescription");

        Doctor doctor = doctorService.getDoctorById(prescriptionDto.getDoctorId());
        Patient patient  = patientService.getPatientById(prescriptionDto.getPatientId());
        Appointment appointment = appointmentService.findAppointmentById(prescriptionDto.getAppointmentId());
        Prescription prescription = prescriptionMapper.toPrescriptionEntity(prescriptionDto);

        prescription.setPatient(patient);
        prescription.setDoctor(doctor);
        prescription.setAppointment(appointment);
        prescription.setPrescribedAt(LocalDateTime.now());

        //for (PrescriptionMedicine medicine : prescription.getPrescribedMedicine()) medicine.setPrescription(prescription);


        //Prescription prescription1 = prescriptionRepository.save(prescription);
        //System.out.println("prescription : " + prescription1);
        return prescriptionRepository.save(prescription);
    }

    @Override
    public void addMedicine(Long prescriptionId, Long medicineId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionException("Prescription Not Found"));
    }

}
