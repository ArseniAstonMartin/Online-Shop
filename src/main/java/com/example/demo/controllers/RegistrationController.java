package com.example.demo.controllers;

import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.UserRegistrationRequest;
import com.example.demo.services.CSRUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private CSRUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/saveUser")
    public String postRegister(UserRegistrationRequest user) {
        var newUser = new MyUser(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userService.saveUser(newUser);
        return "redirect:/login/inputPage";
    }

    @GetMapping("/register/inputPage")
    public String getRegisterInputPage() {
        return "RegistrationPage";
    }

    @GetMapping("/login/inputPage")
    public String getLoginInputPage() {
        return "LoginPage";
    }
}
