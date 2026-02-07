package com.techmaa.onlineexamsystem.user.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmaa.onlineexamsystem.user.dto.RegisterData;
import com.techmaa.onlineexamsystem.user.entity.User;
import com.techmaa.onlineexamsystem.user.repository.UserRepo;

@RestController
@RequestMapping("/register")
public class RegisterUser {
    
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
    public String register(@RequestBody RegisterData registerData) {
        User user = new User();
        user.setUsername(registerData.getUsername());
        user.setPassword(registerData.getPassword());
        user.setRole(registerData.getRole());
        userRepo.save(user);
        return "User Registration Endpoint";
    }
}
