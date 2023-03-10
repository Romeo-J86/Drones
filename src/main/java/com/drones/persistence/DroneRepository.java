package com.drones.persistence;

import com.drones.domain.Drone;
import com.drones.util.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Romeo Jerenyama
 * @created 17/01/2023 - 21:51
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findAllByState(State state);
}
