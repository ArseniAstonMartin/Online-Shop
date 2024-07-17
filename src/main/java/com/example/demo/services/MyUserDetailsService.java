package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUser myUser = myUserRepository.findByEmail(email);
        if(myUser == null) throw new UsernameNotFoundException(email + " user not found");

        UserDetails userDetails = User
                .withUsername(email)
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();
        return userDetails;
    }
}
