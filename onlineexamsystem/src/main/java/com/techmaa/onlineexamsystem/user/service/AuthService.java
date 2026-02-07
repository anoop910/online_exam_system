package com.techmaa.onlineexamsystem.user.service;

import com.techmaa.onlineexamsystem.user.dto.*;
import com.techmaa.onlineexamsystem.user.entity.User;
import com.techmaa.onlineexamsystem.user.repository.UserRepo;
import com.techmaa.onlineexamsystem.user.security.JwtService;

import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthService(UserRepo userRepo,
                       PasswordEncoder encoder,
                       JwtService jwtService,
                       AuthenticationManager authManager) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    // Register
    public String register(RegisterData request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepo.save(user);

        return "User Registered Successfully ✅";
    }

    // Login
    public AuthResponse login(AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow();

        String token =
                jwtService.generateToken(user.getUsername(), user.getRole());

        return new AuthResponse(token);
    }
}
