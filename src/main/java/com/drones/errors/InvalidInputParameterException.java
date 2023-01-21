package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 18:18
 */
public class InvalidInputParameterException extends RuntimeException{
    public InvalidInputParameterException(String message) {
        super(message);
    }
}
