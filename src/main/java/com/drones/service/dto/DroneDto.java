package com.drones.service.dto;

import com.drones.util.DroneModel;
import com.drones.util.State;
import lombok.Data;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 21:53
 */
public record DroneDto (
        Long droneId,
        String serialNumber,
        DroneModel model,
        Integer weightLimit,
        Integer batteryCapacity,
        State state
){
}
