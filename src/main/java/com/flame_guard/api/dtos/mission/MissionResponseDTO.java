package com.flame_guard.api.dtos.mission;

import com.flame_guard.api.domains.drone.Drone;
import com.flame_guard.api.domains.mission.Mission;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MissionResponseDTO {
    private UUID id;
    private Drone drone;
    private Mission.Type type;
    private Mission.Status status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
}
