package com.example.demo.AmazonRepositories;

import com.example.demo.entiteas.Categories;
import com.example.demo.entiteas.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
    List<Product> findByTitleContainingIgnoreCase(String title);
    List<Product> findByCategory(Categories category);
}