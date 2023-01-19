package com.drones.service.medication;

import com.drones.domain.Medication;
import com.drones.errors.InvalidInputParameter;
import com.drones.errors.MedicationNotFoundException;
import com.drones.persistence.MedicationRepository;
import com.drones.service.dto.MedicationDto;
import com.drones.util.AppConstants;
import com.drones.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.drones.util.AppConstants.*;
import static com.drones.util.EntityToDtoUtil.convertToMedicationDto;
import static com.drones.util.ValidationUtil.validateCode;
import static com.drones.util.ValidationUtil.validateName;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 14:49
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService{
    private final MedicationRepository medicationRepository;
    @Override
    public MedicationDto saveMedication(MedicationRequest medicationRequest) {
        requireNonNull(medicationRequest, "MedicationRequest cannot be null");

        validateName(medicationRequest.getName());
        validateCode(medicationRequest.getCode());

        Medication medication = Medication.builder()
                .name(medicationRequest.getName())
                .code(medicationRequest.getCode())
                .weight(medicationRequest.getWeight())
                .image(medicationRequest.getImage())
                .build();

        log.info("Saving medication, medicationRequest = {}", medicationRequest);
        return convertToMedicationDto(medicationRepository.save(medication));
    }
    @Override
    public MedicationDto findMedicationById(Long id) {
        requireNonNull(id, "Medication id cannot be null");

        log.info("Retrieving medication by, id = {}", id);
        return convertToMedicationDto(
                medicationRepository.findById(id).orElseThrow(
                        () -> new MedicationNotFoundException(
                                format(MEDICATION_NOT_FOUND, id))
                ));
    }

}
