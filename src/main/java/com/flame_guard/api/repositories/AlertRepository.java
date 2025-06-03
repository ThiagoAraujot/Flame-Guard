package com.flame_guard.api.repositories;

import com.flame_guard.api.domains.alert.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
}
