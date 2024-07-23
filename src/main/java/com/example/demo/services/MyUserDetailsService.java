package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = myUserRepository.findByUsername(username);
        if(myUser.isEmpty()) throw new UsernameNotFoundException(username + " user not found");
        MyUser mUser = myUser.get();
        return User.builder()
                .username(username)
                .password(mUser.getPassword())
                .roles(getRoles(mUser.getRole()))
                .build();
    }

    private String[] getRoles(String role) {
        if (role == null || role.isBlank()) { return new String[]{"USER"}; }
        return role.split(",");
    }
}
