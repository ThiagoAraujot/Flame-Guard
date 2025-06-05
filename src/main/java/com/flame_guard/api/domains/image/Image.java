package com.flame_guard.api.domains.image;

import com.flame_guard.api.domains.location.Location;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "image")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Image {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private ImageType type;

    private LocalDateTime capturedAt;

    public enum ImageType {
        THERMAL,
        OPTICAL,
        INFRARED
    }
}
