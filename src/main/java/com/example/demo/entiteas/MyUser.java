package com.example.demo.entiteas;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String password;
    private String role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Product> products = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_subscriptions") // Specify the table name for the collection
    @Column(name = "category_value") // Specify the column name for the integers
    private List<Categories> subscriptions = new ArrayList<>();

    public MyUser(UserRegistrationRequest registrationDTO) {
        this.setName(registrationDTO.getName());
        this.setPassword(registrationDTO.getPassword());
        this.setRole(registrationDTO.getRole());
    }

    public void addProduct (Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "MyUser: {" + name + "}";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return getName();
    }

    private String getName() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
