package com.toeic.demo.service;

public interface IJwtService {
    String generateToken(String email, String role);
}
