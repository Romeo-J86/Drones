package com.drones.service.medication;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 14:34
 */
@Data
public class MedicationRequest {
    private String name;
    private Double weight;
    private String code;
    private String image;

}
