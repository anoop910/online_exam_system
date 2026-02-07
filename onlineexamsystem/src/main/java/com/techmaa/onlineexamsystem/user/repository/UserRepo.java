package com.techmaa.onlineexamsystem.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techmaa.onlineexamsystem.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
     Optional<User> findByUsername(String username);
} 
