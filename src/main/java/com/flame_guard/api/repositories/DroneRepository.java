package com.flame_guard.api.repositories;

import com.flame_guard.api.domains.drone.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DroneRepository extends JpaRepository<Drone, UUID> {
}
