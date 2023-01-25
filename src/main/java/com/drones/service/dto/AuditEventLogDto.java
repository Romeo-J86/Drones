package com.drones.service.dto;

import com.drones.util.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Romeo Jerenyama
 * @created 19/01/2023 - 19:08
 */
@Data
public class AuditEventLogDto {
    private Long id;
    private Long droneId;
    private String serialNumber;
    private Integer batteryCapacity;
    private State state;
    private LocalDate createdDate;
}
