package com.flame_guard.api.services;

import com.flame_guard.api.domains.alert.Alert;
import com.flame_guard.api.domains.image.Image;
import com.flame_guard.api.dtos.alert.AlertRequestDTO;
import com.flame_guard.api.dtos.alert.AlertResponseDTO;
import com.flame_guard.api.repositories.AlertRepository;
import com.flame_guard.api.repositories.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlertService {

    private final AlertRepository alertRepository;
    private final ImageRepository imageRepository;

    public AlertService(AlertRepository alertRepository, ImageRepository imageRepository) {
        this.alertRepository = alertRepository;
        this.imageRepository = imageRepository;
    }

    private AlertResponseDTO toResponseDTO(Alert alert) {
        AlertResponseDTO dto = new AlertResponseDTO();

        dto.setId(alert.getId());
        dto.setConfirmed(alert.getConfirmed());
        dto.setDangerLevel(alert.getDangerLevel());
        dto.setReportedAt(alert.getReportedAt());
        dto.setImage(alert.getImage());

        return dto;
    }

    public AlertResponseDTO save(AlertRequestDTO body) {
        Image image = imageRepository.findById(body.getImageId())
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));

        Alert newAlert = new Alert();

        newAlert.setImage(image);
        newAlert.setDangerLevel(body.getDangerLevel());
        newAlert.setConfirmed(body.getConfirmed());
        newAlert.setReportedAt(body.getReportedAt());

        Alert savedAlert = alertRepository.save(newAlert);

        return toResponseDTO(savedAlert);
    }

    public List<AlertResponseDTO> findAll() {
        List<Alert> alerts = alertRepository.findAll();
        return alerts.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public AlertResponseDTO findById(UUID id) {
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alert not found"));

        return toResponseDTO(alert);
    }

    public AlertResponseDTO update(String id, AlertRequestDTO body) {
        Alert alert = alertRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Alert not found"));

        Image image = imageRepository.findById(body.getImageId())
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));

        alert.setImage(image);
        alert.setDangerLevel(body.getDangerLevel());
        alert.setConfirmed(body.getConfirmed());
        alert.setReportedAt(body.getReportedAt());

        Alert updatedAlert = alertRepository.save(alert);
        return toResponseDTO(updatedAlert);
    }

    public void delete(UUID id) {
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alert not found"));
        alertRepository.delete(alert);
    }
}
