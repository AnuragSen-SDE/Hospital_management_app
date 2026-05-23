package com.learnng.HospitalManagement.payment.service.impl;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.service.BillingService;
import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.dto.PaymentDto;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import com.learnng.HospitalManagement.payment.repository.PaymentRepository;
import com.learnng.HospitalManagement.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
                .paymentStatus(PaymentStatus.PENDING)
                .build();

        //will call payment gateway , after payment success or failed the update the state accordingly
        payment.setPaymentStatus(PaymentStatus.PAID);
        payment.setTransactionId("sadghasfsfusfn");
        payment.setPaidAt(LocalDateTime.now());

        //in future if the payable about < paid amount then amount will be added to wallet
        //update the billing
        //billing.setTotalAmount(billing.getTotalAmount() - paymentDto.getAmout());
        billingService.updateBillingDetails(billing);

        //set the billing to the payment entity
        payment.setBilling(billing);


        return paymentRepository.save(payment);
    }
}
