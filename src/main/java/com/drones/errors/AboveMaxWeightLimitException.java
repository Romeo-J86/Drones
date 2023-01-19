package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 19/01/2023 - 18:49
 */
public class AboveMaxWeightLimitException extends RuntimeException {
    public AboveMaxWeightLimitException(String message) {
        super(message);
    }
}
