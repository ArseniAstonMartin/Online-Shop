package com.example.demo.services;

import com.example.demo.AmazonRepositories.MyUserRepository;
import com.example.demo.entiteas.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Optional<MyUser> myUser = myUserRepository.findByName(username);
        if(myUser.isEmpty()) throw new UsernameNotFoundException(username + " user not found");
        return myUser.get();*/
        return myUserRepository.findByName(username).orElseThrow();
    }
}
