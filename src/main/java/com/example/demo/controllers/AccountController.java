package com.example.demo.controllers;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.RegisterDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
     private final MyUserRepository myUserRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setEmail("abc");
        registerDTO.setName("abc");
        registerDTO.setPassword("123");
        model.addAttribute("registerDTO", registerDTO);
        return "register";
    }
    @PostMapping("/finish")
    public String register(Model model, @Valid @ModelAttribute RegisterDTO registerDTO, BindingResult result) {
        MyUser myUser = new MyUser();
        myUser.setRole("USER");
        myUser.setPassword(new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
        myUser.setName(registerDTO.getName());
        myUser.setEmail(registerDTO.getEmail());
        myUserRepository.save(myUser);
        model.addAttribute("registerDTO", new RegisterDTO());
        model.addAttribute("success", true);
        return "register";
    }
}
