package com.flame_guard.api.controllers;

import com.flame_guard.api.dtos.image.ImageRequestDTO;
import com.flame_guard.api.dtos.image.ImageResponseDTO;
import com.flame_guard.api.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageResponseDTO> save(@RequestBody ImageRequestDTO body) {
        ImageResponseDTO image = this.imageService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(image);
    }

    @GetMapping
    public ResponseEntity<List<ImageResponseDTO>> findAll() {
        List<ImageResponseDTO> images = this.imageService.findAll();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageResponseDTO> findById(@PathVariable String id) {
        ImageResponseDTO image = this.imageService.findById(UUID.fromString(id));

        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageResponseDTO> update(@PathVariable String id, @RequestBody ImageRequestDTO body) {
        ImageResponseDTO image = this.imageService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        ImageResponseDTO image = this.imageService.findById(UUID.fromString(id));

        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.imageService.delete(image.getId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
