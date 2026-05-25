package com.learnng.HospitalManagement.bill.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;
import com.learnng.HospitalManagement.bill.entiy.type.BillingItemType;
import com.learnng.HospitalManagement.bill.entiy.type.BillingStatus;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import com.learnng.HospitalManagement.bill.repository.BillingRepository;
import com.learnng.HospitalManagement.bill.service.BillingService;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.exception.custom.BillingException;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final PrescriptionService prescriptionService;

    @Transactional
    @Override
    public Billing generateBillingDetails(BillingDto billingDto) {

        Patient patient = patientService.getPatientById(billingDto.getPatientId());
        Doctor doctor = doctorService.getDoctorById(billingDto.getDoctorId());
        Appointment appointment = appointmentService.findAppointmentById(billingDto.getAppointmentId());
        Prescription prescription = prescriptionService.findPrescriptionById(billingDto.getPrescriptionId());

        if (billingRepository.existsByPrescriptionId(prescription.getId()))
            throw new BillingException("Bill Already exist for the given Prescription");

        Billing billing = Billing.builder()
                .appointment(appointment)
                .patient(patient)
                .doctor(doctor)
                .paidAmount(0.0)
                .billingStatus(BillingStatus.PENDING)
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

        //calculating the total amount
        double totalAmount = billingItems.stream().mapToDouble(BillingItem::getTotalPrice).sum();
        billing.setTotalAmount(totalAmount);
        billing.setDueAmount(totalAmount);


        return billingRepository.save(billing);
    }

    @Override
    public Billing findBillingDetailsById(Long billingId) {
        return billingRepository.findById(billingId).orElseThrow(() ->
                new BillingException("billing data not found")
                );
    }

    @Override
    public Billing updateBillingDetails(Billing billing) {
        return billingRepository.save(billing);
    }
}
