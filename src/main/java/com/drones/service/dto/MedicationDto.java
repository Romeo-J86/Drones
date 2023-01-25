package com.drones.service.dto;

import lombok.Data;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 14:34
 */
public record MedicationDto (
        Long id,
        String name,
        Integer weight,
        String code,
        String image
){
}
