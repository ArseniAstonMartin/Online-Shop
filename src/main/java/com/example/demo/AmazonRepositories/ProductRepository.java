package com.example.demo.AmazonRepositories;

import com.example.demo.entiteas.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findById(long id);
    public List<Product> findByTitleContainingIgnoreCase(String title);
}