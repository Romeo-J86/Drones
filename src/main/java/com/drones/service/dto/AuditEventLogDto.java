package com.drones.service.dto;

import com.drones.util.State;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Romeo Jerenyama
 * @created 19/01/2023 - 19:08
 */
public record AuditEventLogDto (
        Long id,
        Long droneId,
        String serialNumber,
        Integer batteryCapacity,
        State state,
        LocalDate createdDate
){
}
