package com.toeic.demo.service;

import com.toeic.demo.dto.request.LoginRequest;
import com.toeic.demo.dto.request.RegisterRequest;
import com.toeic.demo.dto.response.AuthResponse;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
