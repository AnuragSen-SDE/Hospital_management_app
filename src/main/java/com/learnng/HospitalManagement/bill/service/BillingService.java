package com.learnng.HospitalManagement.bill.service;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;

public interface BillingService {
    Billing generateBillingDetails(BillingDto billingDto);
    Billing findBillingDetailsById(Long billingId);
    Billing updateBillingDetails(Billing billing);
}
