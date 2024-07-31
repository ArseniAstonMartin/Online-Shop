package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "products";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "adminInfo";
    }
    @GetMapping("/userinf")
    public String userPage() {
        return "userInfo";
    }

    @GetMapping("/register/input")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
