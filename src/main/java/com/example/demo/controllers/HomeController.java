package com.example.demo.controllers;

import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String homePage(Model model, Principal principal) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("user", productService.getUserByPrincipal(principal));
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
