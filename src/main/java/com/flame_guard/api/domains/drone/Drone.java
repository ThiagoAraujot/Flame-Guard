package com.flame_guard.api.domains.drone;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Table(name = "drone")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Drone {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 100)
    private String identifier;

    @Column(length = 100)
    private String model;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer autonomyMinutes;

    private Integer waterCapacityMl;

    public enum Status {
        ACTIVE,
        MAINTENANCE,
        UNAVAILABLE
    }
}
