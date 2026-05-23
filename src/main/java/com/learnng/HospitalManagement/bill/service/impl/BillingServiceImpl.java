package com.learnng.HospitalManagement.bill.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;
import com.learnng.HospitalManagement.bill.entiy.type.BillingItemType;
import com.learnng.HospitalManagement.bill.entiy.type.BillingStatus;
import com.learnng.HospitalManagement.bill.repository.BillingRepository;
import com.learnng.HospitalManagement.bill.service.BillingService;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.exception.custom.BillingException;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
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

        if (billingRepository.existsByPrescriptionId(prescription.getId()))
            throw new BillingException("Bill Already exist for the given Prescription");

        Billing billing = Billing.builder()
                .billingStatus(BillingStatus.PENDING)
                .appointment(appointment)
                .patient(patient)
                .doctor(doctor)
                .prescription(prescription)
                .build();

        List<BillingItem> billingItems = new java.util.ArrayList<>(prescription.getPrescribedMedicine().stream()
                .map(
                        (item) -> {
                            System.out.println("unit price: " + item.getUnitPrice());
                            return BillingItem.builder()
                                    .itemName(item.getMedicine().getMedicineName())
                                    .unitPrice(item.getUnitPrice())
                                    .quantity(item.getQuantity())
                                    .totalPrice(item.getUnitPrice() * item.getQuantity())
                                    .billing(billing)
                                    .billingItemType(BillingItemType.MEDICINE)
                                    .build();
                        }).toList());

        //adding the consultant fee of doctor
        billingItems.add(
                0,
                BillingItem.builder()
                        .billingItemType(BillingItemType.CONSULTATION)
                        .billing(billing)
                        .unitPrice(doctor.getConsultationFee())
                        .totalPrice(doctor.getConsultationFee())
                        .itemName("Consultant Fee")
                .build());

        billing.setBillingItems(billingItems);

        double totalAmount = billingItems.stream().mapToDouble(BillingItem::getTotalPrice).sum();

        billing.setTotalAmount(totalAmount);


        return billingRepository.save(billing);
    }

    @Override
    public Billing findBillingDetailsById(Long billingId) {
        return billingRepository.findById(billingId).orElseThrow(() ->
                new BillingException("billing data not found")
                );
    }
}
