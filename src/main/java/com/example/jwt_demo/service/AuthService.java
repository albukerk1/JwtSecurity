package com.example.jwt_demo.service;


import com.example.jwt_demo.entity.User;
import com.example.jwt_demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.jwt_demo.dto.AuthRequest;
import com.example.jwt_demo.dto.AuthResponse;
import com.example.jwt_demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtTokenProvider.generateToken(authentication.getName());
        return new AuthResponse(token);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(AuthRequest request) {
        User newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER") // Novos usuários sempre terão a role "USER"
                .build();
        return userRepository.save(newUser);
    }

}