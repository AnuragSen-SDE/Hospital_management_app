package com.learnng.HospitalManagement.payment.mapper;

import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentDto paymentDto);

    @Mapping(source = "billing.id",target = "billingId")
    PaymentDto toDto(Payment payment);
}
