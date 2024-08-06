package com.example.demo.entiteas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    private String name;
    private String password;
    private String role;
}
