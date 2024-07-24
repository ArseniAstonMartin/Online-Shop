package com.example.demo.controllers;

import com.example.demo.entiteas.MyUser;
import com.example.demo.services.CSRUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RegistrationController {
    @Autowired
    private CSRUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public RedirectView postRegister(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "role") String role, Model model) {
        MyUser user = new MyUser();
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setUsername(username);
        MyUser m = userService.saveUser(user);
        return new RedirectView("/login");
    }
}
