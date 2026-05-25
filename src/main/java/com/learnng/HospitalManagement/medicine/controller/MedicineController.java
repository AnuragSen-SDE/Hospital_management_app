package com.learnng.HospitalManagement.medicine.controller;

import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.medicine.entity.dto.MedicineDto;
import com.learnng.HospitalManagement.medicine.mapper.MedicineMapper;
import com.learnng.HospitalManagement.medicine.service.MedicineService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/medicine")
@Validated
public class MedicineController {
    private final MedicineService medicineService;
    private final MedicineMapper medicineMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> registerMedicine(
            @Valid @RequestBody MedicineDto medicineDto
            ) {
        Medicine medicine = medicineService.registerMedicine(medicineMapper.toEntity(medicineDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Medicine registered Successfully")
                                .data(medicineMapper.toDto(medicine))
                                .build()
                );
    }

    @PutMapping("/{medicineId}/stock")
    public ResponseEntity<ApiResponse> addMedicineStock(
            @PathVariable(name = "medicineId") Long medicineId,
            @RequestParam(name = "quantity") Integer quantity
    ) {
        Medicine medicine = medicineService.addMedicineStock(medicineId,quantity);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Stock update successfully")
                                .data(medicineMapper.toDto(medicine))
                                .build()
                );
    }
}
