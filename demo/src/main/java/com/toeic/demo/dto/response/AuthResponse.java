package com.toeic.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String email;
    private String role;
    private String token;
    private UUID userId;
}
