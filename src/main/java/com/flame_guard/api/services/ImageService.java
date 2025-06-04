package com.flame_guard.api.services;

import com.flame_guard.api.domains.location.Location;
import com.flame_guard.api.domains.image.Image;
import com.flame_guard.api.dtos.image.ImageRequestDTO;
import com.flame_guard.api.dtos.image.ImageResponseDTO;
import com.flame_guard.api.repositories.LocationRepository;
import com.flame_guard.api.repositories.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final LocationRepository locationRepository;

    public ImageService(ImageRepository imageRepository, LocationRepository locationRepository) {
        this.imageRepository = imageRepository;
        this.locationRepository = locationRepository;
    }

    private ImageResponseDTO toResponseDTO(Image image) {
        ImageResponseDTO dto = new ImageResponseDTO();

        dto.setId(image.getId());
        dto.setLocation(image.getLocation());
        dto.setUrl(image.getUrl());
        dto.setType(image.getType());
        dto.setCapturedAt(image.getCapturedAt());

        return dto;
    }

    public ImageResponseDTO save(ImageRequestDTO body) {
        Location location = locationRepository.findById(body.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        Image newImage = new Image();

        newImage.setLocation(location);
        newImage.setUrl(body.getUrl());
        newImage.setType(body.getType());
        newImage.setCapturedAt(body.getCapturedAt());

        Image savedImage = imageRepository.save(newImage);

        return toResponseDTO(savedImage);
    }

    public List<ImageResponseDTO> findAll() {
        List<Image> images = imageRepository.findAll();
        return images.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ImageResponseDTO findById(UUID id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));

        return toResponseDTO(image);
    }

    public ImageResponseDTO update(String id, ImageRequestDTO body) {
        Image image = imageRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));

        Location location = locationRepository.findById(body.getLocationId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        image.setLocation(location);
        image.setUrl(body.getUrl());
        image.setType(body.getType());
        image.setCapturedAt(body.getCapturedAt());

        Image updatedImage = imageRepository.save(image);
        return toResponseDTO(updatedImage);
    }

    public void delete(UUID id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));
        imageRepository.delete(image);
    }
}
