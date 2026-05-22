package com.learnng.HospitalManagement.bill.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;
import com.learnng.HospitalManagement.bill.entiy.type.BillingStatus;
import com.learnng.HospitalManagement.bill.repository.BillingRepository;
import com.learnng.HospitalManagement.bill.service.BillingService;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final PrescriptionService prescriptionService;

    @Override
    public Billing generateBillingDetails(BillingDto billingDto) {

        Patient patient = patientService.getPatientById(billingDto.getPatientId());
        Doctor doctor = doctorService.getDoctorById(billingDto.getDoctorId());
        Appointment appointment = appointmentService.findAppointmentById(billingDto.getAppointmentId());
        Prescription prescription = prescriptionService.findPrescriptionById(billingDto.getPrescriptionId());

        Billing billing = Billing.builder()
                .billingStatus(BillingStatus.PENDING)
                .appointment(appointment)
                .patient(patient)
                .doctor(doctor)
                .prescription(prescription)
                .build();

        Set<BillingItem> billingItems =  prescription.getPrescribedMedicine().stream()
                .map(
                        (item) -> {
                            return BillingItem.builder()
                                    .itemName(item.getMedicine().getMedicineName())
                                    .unitPrice(item.getUnitPrice())
                                    .quantity(item.getQuantity())
                                    .totalPrice(item.getUnitPrice() * item.getQuantity())
                                    .billing(billing)
                                    .build();
                        }).collect(Collectors.toSet());

        billing.setBillingItems(billingItems);

        double totalAmount = billingItems.stream().mapToDouble(BillingItem::getTotalPrice).sum();

        billing.setTotalAmount(totalAmount);


        return billingRepository.save(billing);
    }
}
