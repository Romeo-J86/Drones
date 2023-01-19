package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 18:18
 */
public class InvalidInputParameter extends RuntimeException{
    public InvalidInputParameter(String message) {
        super(message);
    }
}
