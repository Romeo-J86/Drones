package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 15:00
 */
public class MedicationNotFoundException extends RuntimeException{
    public MedicationNotFoundException(String message) {
        super(message);
    }
}
