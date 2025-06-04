package com.flame_guard.api.dtos.image;

import com.flame_guard.api.domains.image.Image;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ImageRequestDTO {
    private UUID locationId;
    private String url;
    private Image.ImageType type;
    private LocalDateTime capturedAt;
}
