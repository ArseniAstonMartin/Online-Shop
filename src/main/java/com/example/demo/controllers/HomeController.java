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
    @GetMapping("/user")
    public String userPage() {
        return "userInfo";
    }


}
