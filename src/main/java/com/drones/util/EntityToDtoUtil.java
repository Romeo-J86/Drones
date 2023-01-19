package com.drones.util;

import com.drones.domain.AuditEventLog;
import com.drones.domain.Drone;
import com.drones.domain.Medication;
import com.drones.service.dto.AuditEventLogDto;
import com.drones.service.dto.DroneDto;
import com.drones.service.dto.MedicationDto;
import org.springframework.beans.BeanUtils;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 22:04
 */
public class EntityToDtoUtil {
    public static DroneDto convertToDroneDto(Drone drone){
        DroneDto droneDto = new DroneDto();
        BeanUtils.copyProperties(drone, droneDto);
        return droneDto;
    }
    public static MedicationDto convertToMedicationDto(Medication medication){
        MedicationDto medicationDto = new MedicationDto();
        BeanUtils.copyProperties(medication, medicationDto);
        return medicationDto;
    }
    public static AuditEventLogDto convertToAuditEventLogDto(AuditEventLog auditEventLog){
        AuditEventLogDto auditEventLogDto = new AuditEventLogDto();
        BeanUtils.copyProperties(auditEventLog, auditEventLogDto);
        return auditEventLogDto;
    }
}
