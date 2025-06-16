package com.example.jwt_demo.dto;

import lombok.*;

@Data
public class AuthRequest {
    private String username;
    private String password;
}