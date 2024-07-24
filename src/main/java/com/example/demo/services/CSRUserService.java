package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CSRUserService {
    private final MyUserRepository repository;

    MyUser findByUsername(String username) {
        Optional<MyUser> user = repository.findByUsername(username);
        if (user.isPresent()) {
            MyUser usObj = user.get();
            log.info("Returning user, {}", user);
            return usObj;
        }
        log.info("User not found, username = {}", username);
        throw new UsernameNotFoundException("User not found, username = " + username);
    }

    public MyUser saveUser(MyUser user) {
        log.info("Saving {}", user);
        return repository.save(user);
    }
}
