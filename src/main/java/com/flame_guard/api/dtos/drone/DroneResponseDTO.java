package com.flame_guard.api.dtos.drone;

import com.flame_guard.api.domains.drone.Drone;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DroneResponseDTO {
    private UUID id;
    private String identifier;
    private String model;
    private Drone.Status status;
    private Integer autonomyMinutes;
    private Integer waterCapacityMl;
}
