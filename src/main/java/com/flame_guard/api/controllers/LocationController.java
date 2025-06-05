package com.flame_guard.api.controllers;

import com.flame_guard.api.dtos.location.LocationRequestDTO;
import com.flame_guard.api.dtos.location.LocationResponseDTO;
import com.flame_guard.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResponseDTO> save(@RequestBody LocationRequestDTO body) {
        LocationResponseDTO location = this.locationService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(location);
    }

    @GetMapping
    public ResponseEntity<List<LocationResponseDTO>> findAll() {
        List<LocationResponseDTO> locations = this.locationService.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDTO> findById(@PathVariable String id) {
        LocationResponseDTO location = this.locationService.findById(UUID.fromString(id));

        if (location == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationResponseDTO> update(@PathVariable String id, @RequestBody LocationRequestDTO body) {
        LocationResponseDTO location = this.locationService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        LocationResponseDTO location = this.locationService.findById(UUID.fromString(id));

        if (location == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.locationService.delete(location.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
