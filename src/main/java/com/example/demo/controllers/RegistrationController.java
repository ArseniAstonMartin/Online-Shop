package com.example.demo.controllers;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.LoginForm;
import com.example.demo.entiteas.MyUser;
import com.example.demo.services.JWTService;
import com.example.demo.services.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));
        if (authentication.isAuthenticated()) {
            String str = jwtService.generateToken(userDetailsService.loadUserByUsername(loginForm.username()));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", str);
            return new ResponseEntity<>(headers, HttpStatusCode.valueOf(200));
        }
        else throw new UsernameNotFoundException("Invalid credentials");
    }

    @PostMapping("/register/user")
    public RedirectView postRegister(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "role") String role, Model model) {
        log.info("SAving user");
        MyUser user = new MyUser();
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(username);
        MyUser m = myUserRepository.save(user);
        return new RedirectView("/login");
    }
}
