package com.techmaa.onlineexamsystem.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterData {
    private String username;
    private String password;
    private String role;
}
