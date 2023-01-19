package com.drones.domain;

import com.drones.util.DroneModel;
import com.drones.util.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 21:34
 */
@Data
@Entity
@Table(name = "drone")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, updatable = false)
    private Long droneId;
    @NotNull(message = "Serial number cannot be null")
    @Column(length = 100, unique = true)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModel model;
    @Max(value = 500, message = "Weight limit is 500")

    private Integer weightLimit;
    @Max(100)
    @Min(0)
    private Integer batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private Medication medication;
}
