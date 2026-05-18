package com.learnng.HospitalManagement.exception.custom;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    private HttpStatus httpStatus;

}
