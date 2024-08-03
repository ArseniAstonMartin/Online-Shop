package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.ReqRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private MyUserRepository userRepo;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ReqRes register(ReqRes request) {
        ReqRes response = new ReqRes();

        try {
            MyUser newUser = new MyUser();
            newUser.setName(request.getName());
            newUser.setRole(request.getRole());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser = userRepo.save(newUser);
            if (newUser.getId() > 0) {
                response.setUser(newUser);
                response.setStatusCode(200);
                response.setMessage("User saved successfully");
            }
        } catch (Exception e) {
            response.setError(e.getMessage());
            response.setStatusCode(500);
        }
        return response;
    }

    public ReqRes login(ReqRes request) {
        ReqRes response = new ReqRes();
        try {
            var authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
            var auth = SecurityContextHolder.getContext();
            auth.setAuthentication(authentication);
            SecurityContextHolder.setContext(auth);


            MyUser user = userRepo.findByName(request.getName()).orElseThrow();
            String jwt = jwtService.generateToken(user);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setStatusCode(200);
            response.setMessage("Succesfully logged in");
            response.setExpirationTime("30 minutes");
        }
        catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setStatusCode(500);
        }
        return response;
    }
}
