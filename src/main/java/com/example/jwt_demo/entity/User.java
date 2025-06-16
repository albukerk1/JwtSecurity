package com.example.jwt_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Adicione esta linha
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
}