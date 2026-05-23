package com.learnng.HospitalManagement.payment.repository;

import com.learnng.HospitalManagement.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
