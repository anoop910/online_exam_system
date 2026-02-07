package com.techmaa.onlineexamsystem.user.service;

import com.techmaa.onlineexamsystem.user.repository.UserRepo;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepo.findByUsername(username)
                .map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRole()) // ADMIN / STUDENT
                        .build()
                )
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
    }
}
