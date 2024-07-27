package com.example.demo.controllers;

import com.example.demo.entiteas.MyUser;
import com.example.demo.services.CSRUserService;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final CSRUserService userService;
    private final ProductService productService;

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable MyUser user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "userInfo";
    }
}
