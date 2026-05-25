package com.learnng.HospitalManagement.bill.mapper;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {BillingItemMapper.class}
)
public interface BillingMapper {

    @Mapping(source = "patient.id",target = "patientId")
    @Mapping(target = "doctorId",source = "doctor.id")
    @Mapping(target = "appointmentId",source = "appointment.id")
    @Mapping(target = "prescriptionId",source = "prescription.id")
    BillingDto toDto(Billing billing );

    Billing toEntity( BillingDto billingDto);
}
