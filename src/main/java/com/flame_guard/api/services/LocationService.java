package com.flame_guard.api.services;

import com.flame_guard.api.domains.location.Location;
import com.flame_guard.api.domains.mission.Mission;
import com.flame_guard.api.dtos.location.LocationRequestDTO;
import com.flame_guard.api.dtos.location.LocationResponseDTO;
import com.flame_guard.api.repositories.LocationRepository;
import com.flame_guard.api.repositories.MissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final MissionRepository missionRepository;

    public LocationService(LocationRepository locationRepository, MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
        this.locationRepository = locationRepository;
    }

    private LocationResponseDTO toResponseDTO(Location location) {
        LocationResponseDTO dto = new LocationResponseDTO();

        dto.setId(location.getId());
        dto.setMission(location.getMission());
        dto.setLatitude(location.getLatitude());
        dto.setLongitude(location.getLongitude());
        dto.setCapturedAt(location.getCapturedAt());

        return dto;
    }

    public LocationResponseDTO save(LocationRequestDTO body) {
        Mission mission = missionRepository.findById(body.getMissionId())
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));

        Location newLocation = new Location();

        newLocation.setLatitude(body.getLatitude());
        newLocation.setLongitude(body.getLongitude());
        newLocation.setCapturedAt(body.getCapturedAt());
        newLocation.setMission(mission);

        Location savedLocation = locationRepository.save(newLocation);

        return toResponseDTO(savedLocation);
    }

    public List<LocationResponseDTO> findAll() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public LocationResponseDTO findById(UUID id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        return toResponseDTO(location);
    }

    public LocationResponseDTO update(String id, LocationRequestDTO body) {
        Location location = locationRepository.findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        Mission mission = missionRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));

        location.setLatitude(location.getLatitude());
        location.setLongitude(location.getLongitude());
        location.setCapturedAt(location.getCapturedAt());
        location.setMission(mission);


        Location updatedLocation = locationRepository.save(location);
        return toResponseDTO(updatedLocation);
    }

    public void delete(UUID id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found"));
        locationRepository.delete(location);
    }
}
