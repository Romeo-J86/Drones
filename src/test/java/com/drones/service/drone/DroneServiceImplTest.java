package com.drones.service.drone;

import com.drones.domain.Drone;
import com.drones.domain.Medication;
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
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    @Mock
    private ModelMapper modelMapper;
    private Drone drone;
    private DroneRequest droneRequest;
    private Medication medication;
    private DroneService underTest;
    @BeforeEach
    void setUp() {
        underTest = new DroneServiceImpl(modelMapper,droneRepository, medicationRepository);
        medication = Medication.builder()
                .id(1l)
                .code("A5")
                .name("Paracetamol")
                .image("Image")
                .weight(52)
                .build();

    }
    @Test
    @DisplayName("Given valid DroneRequest registerDrone method should register Drone")
    void givenValidRequest_ShouldRegisterDrone() {
        //GIVEN
        DroneRequest droneRequest = new DroneRequest();
        droneRequest.setSerialNumber("123456");
        droneRequest.setState(State.LOADING);
        droneRequest.setModel(DroneModel.Cruiserweight);
        droneRequest.setWeightLimit(12);
        droneRequest.setBatteryCapacity(45);

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

        Drone capturedDrone = droneArgumentCaptor.getValue();

        assertThat(capturedDrone).isEqualTo(expectedDrone);

    }
    @Test
    void findDroneById() {
    }
}