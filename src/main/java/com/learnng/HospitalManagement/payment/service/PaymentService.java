package com.learnng.HospitalManagement.payment.service;

import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.dto.PaymentDto;

public interface PaymentService {
    Payment processPayment(PaymentDto paymentDto);
}
