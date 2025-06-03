package com.flame_guard.api.domains.alert;

import com.flame_guard.api.domains.image.Image;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "alert")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alert {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(length = 50)
    private DangerLevel dangerLevel;

    private Boolean confirmed;

    private LocalDateTime reportedAt;

    public enum DangerLevel {
        LOW,
        MEDIUM,
        HIGH
    }
}
