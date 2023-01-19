package com.drones.service.event_log;

import com.drones.domain.AuditEventLog;
import com.drones.service.dto.AuditEventLogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Romeo Jerenyama
 * @created 19/01/2023 - 16:38
 */
public interface AuditEventLogService {
    Page<AuditEventLogDto> filterByDate(LocalDate date, Pageable pageable);
}
