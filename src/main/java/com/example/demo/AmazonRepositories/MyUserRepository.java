package com.example.demo.AmazonRepositories;

import com.example.demo.entiteas.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByEmail(String email);
}
