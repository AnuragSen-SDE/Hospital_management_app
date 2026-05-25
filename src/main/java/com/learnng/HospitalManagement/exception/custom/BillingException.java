package com.learnng.HospitalManagement.exception.custom;

import com.learnng.HospitalManagement.bill.entiy.Billing;

public class BillingException extends RuntimeException{
    public BillingException ( String messaage) {super(messaage);}
}
