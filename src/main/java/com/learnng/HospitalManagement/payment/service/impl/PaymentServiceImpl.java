package com.learnng.HospitalManagement.payment.service.impl;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.type.BillingStatus;
import com.learnng.HospitalManagement.bill.service.BillingService;
import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.dto.PaymentDto;
import com.learnng.HospitalManagement.payment.entity.type.PaymentMethod;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import com.learnng.HospitalManagement.payment.repository.PaymentRepository;
import com.learnng.HospitalManagement.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillingService billingService;

    @Transactional
    @Override
    public Payment processPayment(PaymentDto paymentDto) {
        Billing billing = billingService.findBillingDetailsById(paymentDto.getBillingId());

        Payment payment = Payment.builder()
                .paymentMethod(paymentDto.getPaymentMethod())
                .amount(paymentDto.getAmount())
                .paymentStatus(PaymentStatus.PENDING)
                .build();

        //will call payment gateway , after payment success or failed the update the state accordingly
        payment.setPaymentStatus(PaymentStatus.PAID);
        if (paymentDto.getPaymentMethod() != PaymentMethod.CASH )payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaidAt(LocalDateTime.now());

        //in future if the payable about < paid amount then amount will be added to wallet
        //update the billing
        billing.setDueAmount(billing.getTotalAmount() - paymentDto.getAmount());
        billing.setPaidAmount(paymentDto.getAmount() + billing.getPaidAmount());
        billingService.updateBillingDetails(billing);

        //check billing status
        if (billing.getDueAmount() == 0 ) billing.setBillingStatus(BillingStatus.PAID);
        else billing.setBillingStatus(BillingStatus.PARTIALLY_PAID);

        //set the billing to the payment entity
        payment.setBilling(billing);


        return paymentRepository.save(payment);
    }
}
