package com.learnng.HospitalManagement.bill.entiy;

import com.learnng.HospitalManagement.bill.entiy.type.BillingItemType;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BillingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Billing billing;

    @NotBlank
    private String  itemName;

    @Min(0)
    private Integer quantity;

    @NotNull
    @Min(0)
    private Double unitPrice;

    @NotNull
    @Min(0)
    private Double totalPrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BillingItemType billingItemType;

}
