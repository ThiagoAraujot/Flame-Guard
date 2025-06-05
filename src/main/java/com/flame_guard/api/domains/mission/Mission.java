package com.flame_guard.api.domains.mission;

import com.flame_guard.api.domains.drone.Drone;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "mission")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mission {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private Drone drone;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    public enum Type {
        MONITORING,
        COMBAT,
        TEST
    }

    public enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        FAILED
    }
}
