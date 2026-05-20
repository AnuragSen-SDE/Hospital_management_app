package com.learnng.HospitalManagement.exception.controller;

import com.learnng.HospitalManagement.exception.custom.AppointmentException;
import com.learnng.HospitalManagement.exception.custom.InsuranceException;
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


}
