package com.drones.service;

import com.drones.domain.Drone;
import com.drones.persistence.DroneRepository;
import com.drones.persistence.MedicationRepository;
import com.drones.service.drone.DroneRequest;
import com.drones.service.drone.DroneService;
import com.drones.service.drone.DroneServiceImpl;
import com.drones.util.DroneModel;
import com.drones.util.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 23:27
 */
@ExtendWith(MockitoExtension.class)
class DroneServiceImplTest {

    @Mock
    private DroneRepository droneRepository;
    @Mock
    private MedicationRepository medicationRepository;
    private DroneService underTest;
    @BeforeEach
    void setUp() {
        underTest = new DroneServiceImpl(droneRepository, medicationRepository);
    }

    @Test
    @DisplayName("Given valid DroneRequest registerDrone method should register Drone")
    void givenValidRequest_ShouldRegisterDrone() {
        //GIVEN
        DroneRequest droneRequest = new DroneRequest();
        droneRequest.setSerialNumber("123456");
        droneRequest.setState(State.LOADING);
        droneRequest.setModel(DroneModel.Cruiserweight);
        droneRequest.setWeightLimit(12.0);
        droneRequest.setBatteryCapacity(45.0);

        //WHEN
        underTest.registerDrone(droneRequest);
        //THEN
        Drone expectedDrone = Drone.builder()
                .serialNumber(droneRequest.getSerialNumber())
                .model(droneRequest.getModel())
                .state(droneRequest.getState())
                .batteryCapacity(droneRequest.getBatteryCapacity())
                .weightLimit(droneRequest.getWeightLimit())
                .build();

        ArgumentCaptor<Drone> droneArgumentCaptor =
                ArgumentCaptor.forClass(Drone.class);
        verify(droneRepository).save(droneArgumentCaptor.capture());
    }

    @Test
    void findDroneById() {
    }
}