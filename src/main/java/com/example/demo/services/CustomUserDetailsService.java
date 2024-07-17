package com.example.demo.services;

import com.example.demo.AmazonRepositories.UserRepository;
import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<MyUser> res = userRepository.findByEmail(email);

        if (res.isPresent()) {
            MyUser userObj = res.get();
            return User.builder()
                    .username(userObj.getEmail())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }
        else throw new UsernameNotFoundException("user " + email +" is null");
    }

    private String[] getRoles(MyUser userObj) {
        Set<Role> roles = userObj.getRoles();
        roles.add(Role.ROLE_USER);
        return roles.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }
}
