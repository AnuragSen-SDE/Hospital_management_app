package com.learnng.HospitalManagement.util.Entity;

public record ApiResponse(
        int status,
        String message,
        Object data
) {
}
