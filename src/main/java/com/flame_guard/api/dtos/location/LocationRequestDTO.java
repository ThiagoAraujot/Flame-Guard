package com.flame_guard.api.dtos.location;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class LocationRequestDTO {
    private UUID missionId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime capturedAt;
}
