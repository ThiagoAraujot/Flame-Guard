package com.flame_guard.api.dtos.alert;

import com.flame_guard.api.domains.alert.Alert;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AlertRequestDTO {
    private UUID imageId;
    private Alert.DangerLevel dangerLevel;
    private Boolean confirmed;
    private LocalDateTime reportedAt;
}
