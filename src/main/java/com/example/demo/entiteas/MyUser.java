package com.example.demo.entiteas;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String role; // ADMIN,USER
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Product> products = new ArrayList<>();

    public void addProduct (Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "MyUser {" +
                "\n\tid=" + id +
                "\n\t, username='" + username + '\'' +
                "\n\t, role='" + role + '\'' +
                "\n}";
    }
}
