package com.drones.persistence;

import com.drones.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 14:03
 */
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Optional<Medication> findByCode(String code);
}
