package com.drones.service.dto;

import lombok.Data;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 14:34
 */
@Data
public class MedicationDto {
    private Long id;
    private String name;
    private Double weight;
    private String code;
    private String image;
}
