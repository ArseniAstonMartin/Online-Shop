package com.example.demo.controllers;

import com.example.demo.errors.EntityNotFoundException;
import com.example.demo.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/image/{id}")
    private ResponseEntity<?> getImageById(@PathVariable long id) throws EntityNotFoundException {
        return imageService.getImageById(id);
    }
}