package com.example.demo.entiteas;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String name;

    @Size(min=3, message = "too small password")
    private String password;
}
