package com.learnng.HospitalManagement.bill.mapper;

import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillingItemMapper {

    BillingItem toEntity (BillingItemDto billingItemDto);

    @Mapping(target = "billingId", source = "billing.id")
    BillingItemDto toDto (BillingItem billingItem);
}
