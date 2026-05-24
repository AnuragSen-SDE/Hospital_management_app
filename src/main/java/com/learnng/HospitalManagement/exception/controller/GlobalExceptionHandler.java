package com.learnng.HospitalManagement.exception.controller;

import com.learnng.HospitalManagement.exception.custom.*;
import com.learnng.HospitalManagement.exception.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException (
            MethodArgumentNotValidException exception
    ) {
        Map<String ,String > map = new HashMap<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> map.put(error.getField(),error.getDefaultMessage()));

        return ResponseEntity.badRequest()
                .body(
                        ErrorResponse.builder()
                                .status(HttpStatus.BAD_REQUEST.value())
                                .data(map)
                                .build()
                );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleArgumentValidationException (
            MethodArgumentTypeMismatchException exception
    ) {
        String message = "Invalid value : " + exception.getValue();

        if (exception.getRequiredType() != null &&
                exception.getRequiredType().isEnum()) {

            Object[] enumConstants = exception.getRequiredType().getEnumConstants();

            message = "Invalid appointment status '" + exception.getValue()
                    + "'. Allowed values are: "
                    + java.util.Arrays.toString(enumConstants);
        }

        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(message)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity<ErrorResponse> appointmentExceptionHandler(
            AppointmentException appointmentException
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(appointmentException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(DoctorException.class)
    public ResponseEntity<ErrorResponse> handleDoctorExceptionHandler(
            DoctorException doctorException
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(doctorException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(InsuranceException.class)
    public ResponseEntity<ErrorResponse> handleInsuranceException(
            InsuranceException exception
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(PrescriptionException.class)
    public ResponseEntity<ErrorResponse> handlePrescriptionException(
            PrescriptionException exception
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(BillingException.class)
    public ResponseEntity<ErrorResponse> handleBillingException(
            BillingException exception
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ErrorResponse> handlePatientException(
            PatientException exception
    ) {
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorResponse> handlePaymentException(
            PaymentException exception
    ){
        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


}
