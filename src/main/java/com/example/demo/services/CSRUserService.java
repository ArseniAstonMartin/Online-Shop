package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CSRUserService {
    private final MyUserRepository repository;

    public MyUser findByName(String name) {
        Optional<MyUser> user = repository.findByName(name);
        if (user.isPresent()) {
            MyUser usObj = user.get();
            log.info("Returning user, {}", user);
            return usObj;
        }
        log.info("User not found, username = {}", name);
        throw new UsernameNotFoundException("User not found, username = " + name);
    }

    public MyUser saveUser(MyUser user) {
        log.info("Saving {}", user);
        return repository.save(user);
    }
    public MyUser getUserByPrincipal(Principal principal) {
        if (principal == null) return new MyUser();
        return findByName(principal.getName());
    }

}
