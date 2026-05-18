package com.learnng.HospitalManagement.util.Entity;

import lombok.Builder;

@Builder
public record ApiResponse(
        int status,
        String message,
        Object data
) {
}
