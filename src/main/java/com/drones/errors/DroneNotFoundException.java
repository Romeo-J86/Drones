package com.drones.errors;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 22:23
 */
public class DroneNotFoundException extends RuntimeException{
    public DroneNotFoundException(String message) {
        super(message);
    }
}
