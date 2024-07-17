package com.example.demo.services;

import com.example.demo.AmazonRepositories.UserRepository;
import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.enums.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(MyUser user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email).isPresent()) return false;
        var roles = user.getRoles();
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email {}", email);
        return true;
    }
}
