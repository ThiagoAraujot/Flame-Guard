package com.flame_guard.api.controllers;

import com.flame_guard.api.dtos.mission.MissionRequestDTO;
import com.flame_guard.api.dtos.mission.MissionResponseDTO;
import com.flame_guard.api.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/missions")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @PostMapping
    public ResponseEntity<MissionResponseDTO> save(@RequestBody MissionRequestDTO body) {
        MissionResponseDTO mission = this.missionService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(mission);
    }

    @GetMapping
    public ResponseEntity<List<MissionResponseDTO>> findAll() {
        List<MissionResponseDTO> missions = this.missionService.findAll();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionResponseDTO> findById(@PathVariable String id) {
        MissionResponseDTO mission = this.missionService.findById(UUID.fromString(id));

        if (mission == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(mission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionResponseDTO> update(@PathVariable String id, @RequestBody MissionRequestDTO body) {
        MissionResponseDTO mission = this.missionService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(mission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        MissionResponseDTO mission = this.missionService.findById(UUID.fromString(id));

        if (mission == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.missionService.delete(mission.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
