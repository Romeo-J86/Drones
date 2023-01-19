package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 19/01/2023 - 12:41
 */
public class DroneLoadingFailedException extends RuntimeException{
    public DroneLoadingFailedException(String message) {
        super(message);
    }
}
