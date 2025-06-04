package com.flame_guard.api.dtos.alert;

import com.flame_guard.api.domains.alert.Alert;
import com.flame_guard.api.domains.image.Image;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AlertResponseDTO {
    private UUID id;
    private Image image;
    private Alert.DangerLevel dangerLevel;
    private Boolean confirmed;
    private LocalDateTime reportedAt;
}
