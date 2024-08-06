package com.example.demo.controllers;

import com.example.demo.services.CSRUserService;
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
    private final CSRUserService userService;

    @GetMapping("/")
    public String homePage(Model model, Principal principal) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "HomePage";
    }
    @GetMapping("/admin/home")
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("userObject", userService.findByName(principal.getName()));
        return "AdminHome";
    }
    @GetMapping("/user/home")
    public String userPage(Model model, Principal principal) {
        model.addAttribute("userObject", userService.findByName(principal.getName()));
        return "UserHome";
    }

}
