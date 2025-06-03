package com.flame_guard.api.domains.location;

import com.flame_guard.api.domains.mission.Mission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "location")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    private Double latitude;

    private Double longitude;

    private LocalDateTime capturedAt;
}
