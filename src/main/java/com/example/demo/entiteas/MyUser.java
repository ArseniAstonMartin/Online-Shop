package com.example.demo.entiteas;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class MyUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    @Column(length = 1000)
    private String password;
    private String role; // ADMIN,USER
}
