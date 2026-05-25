package com.learnng.HospitalManagement.bill.entiy.dto;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.type.BillingItemType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillingItemDto {

    private Long id;

    private Long billingId;

    private String  itemName;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private BillingItemType billingItemType;
}
