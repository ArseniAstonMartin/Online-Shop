package com.example.demo.AmazonRepositories;

import com.example.demo.entiteas.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}