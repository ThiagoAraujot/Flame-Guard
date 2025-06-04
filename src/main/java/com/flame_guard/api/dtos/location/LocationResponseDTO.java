package com.flame_guard.api.dtos.location;

import com.flame_guard.api.domains.mission.Mission;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class LocationResponseDTO {
    private UUID id;
    private Mission mission;
    private Double latitude;
    private Double longitude;
    private LocalDateTime capturedAt;
}
