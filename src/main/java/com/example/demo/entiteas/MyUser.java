package com.example.demo.entiteas;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class MyUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // ADMIN,USER
}
