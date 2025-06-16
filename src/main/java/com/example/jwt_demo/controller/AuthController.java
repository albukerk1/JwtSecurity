package com.example.jwt_demo.controller;

import com.example.jwt_demo.dto.AuthRequest;
import com.example.jwt_demo.dto.AuthResponse;
import com.example.jwt_demo.entity.User;
import com.example.jwt_demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public User register(@RequestBody AuthRequest request) {
        return authService.register(request);
    }

}