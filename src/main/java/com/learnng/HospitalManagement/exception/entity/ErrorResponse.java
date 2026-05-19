package com.learnng.HospitalManagement.exception.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
public record ErrorResponse(
        int status,
        String message,
        Object data
) {


}
