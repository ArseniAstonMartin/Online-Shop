package com.example.demo.AmazonRepositories;

import com.example.demo.entiteas.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String name);
}
