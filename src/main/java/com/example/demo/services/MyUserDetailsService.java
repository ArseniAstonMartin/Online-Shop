package com.example.demo.services;

import com.example.demo.entiteas.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private CSRUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser mUser = userService.findByUsername(username);
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

    private String[] getAuthorities (String authority) {
        if (authority == null || authority.isBlank()) { return new String[]{"USER"}; }
        return authority.split(",");
    }
}
