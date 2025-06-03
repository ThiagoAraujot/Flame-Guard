package com.flame_guard.api.repositories;

import com.flame_guard.api.domains.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
