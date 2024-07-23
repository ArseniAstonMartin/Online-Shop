package com.example.demo.controllers;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;

@RestController
@Slf4j
public class RegistrationController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public RedirectView postRegister(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "role") String role, Model model) {
        log.info("SAving user");
        MyUser user = new MyUser();
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        MyUser m = myUserRepository.save(user);
        return new RedirectView("/login");
    }
}
