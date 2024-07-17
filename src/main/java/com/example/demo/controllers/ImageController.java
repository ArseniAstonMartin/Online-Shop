package com.example.demo.controllers;

import com.example.demo.AmazonRepositories.ImageRepository;
import com.example.demo.entiteas.Image;
import com.example.demo.services.ImageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/image/{id}")
    private ResponseEntity<?> getImageById(@PathVariable long id) {
        return imageService.getImageById(id);
    }
}
