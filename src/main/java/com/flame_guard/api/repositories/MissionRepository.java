package com.flame_guard.api.repositories;

import com.flame_guard.api.domains.mission.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissionRepository extends JpaRepository<Mission, UUID> {
}
