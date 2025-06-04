package com.flame_guard.api.services;

import com.flame_guard.api.domains.drone.Drone;
import com.flame_guard.api.domains.mission.Mission;
import com.flame_guard.api.dtos.mission.MissionRequestDTO;
import com.flame_guard.api.dtos.mission.MissionResponseDTO;
import com.flame_guard.api.repositories.DroneRepository;
import com.flame_guard.api.repositories.MissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MissionService {

    private final MissionRepository missionRepositoy;
    private final DroneRepository droneRepository;

    public MissionService(MissionRepository missionRepositoy, DroneRepository droneRepository) {
        this.missionRepositoy = missionRepositoy;
        this.droneRepository = droneRepository;
    }

    private MissionResponseDTO toResponseDTO(Mission mission) {
        MissionResponseDTO dto = new MissionResponseDTO();

        dto.setId(mission.getId());
        dto.setType(mission.getType());
        dto.setStatus(mission.getStatus());
        dto.setStartTime(mission.getStartTime());
        dto.setEndTime(mission.getEndTime());
        dto.setDescription(mission.getDescription());
        dto.setDrone(mission.getDrone());

        return dto;
    }

    public MissionResponseDTO save(MissionRequestDTO body) {
        Drone drone = droneRepository.findById(body.getDroneId())
                .orElseThrow(() -> new EntityNotFoundException("Drone not found"));

        Mission newMission = new Mission();

        newMission.setDrone(drone);
        newMission.setType(body.getType());
        newMission.setStatus(body.getStatus());
        newMission.setStartTime(body.getStartTime());
        newMission.setEndTime(body.getEndTime());
        newMission.setDescription(body.getDescription());

        Mission savedMission = missionRepositoy.save(newMission);

        return toResponseDTO(savedMission);
    }

    public List<MissionResponseDTO> findAll() {
        List<Mission> missions = missionRepositoy.findAll();
        return missions.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public MissionResponseDTO findById(UUID id) {
        Mission mission = missionRepositoy.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));

        return toResponseDTO(mission);
    }

    public MissionResponseDTO update(String id, MissionRequestDTO body) {
        Mission mission = missionRepositoy.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));

        Drone drone = droneRepository.findById(body.getDroneId())
                .orElseThrow(() -> new EntityNotFoundException("Drone not found"));

        mission.setDrone(drone);
        mission.setType(body.getType());
        mission.setStatus(body.getStatus());
        mission.setStartTime(body.getStartTime());
        mission.setEndTime(body.getEndTime());
        mission.setDescription(body.getDescription());


        Mission updatedMission = missionRepositoy.save(mission);
        return toResponseDTO(updatedMission);
    }

    public void delete(UUID id) {
        Mission mission = missionRepositoy.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));
        missionRepositoy.delete(mission);
    }
}
