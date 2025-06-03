package com.flame_guard.api.repositories;

import com.flame_guard.api.domains.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}
