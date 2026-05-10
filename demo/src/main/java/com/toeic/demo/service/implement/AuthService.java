package com.toeic.demo.service.implement;

import com.toeic.demo.constants.Role;
import com.toeic.demo.dto.request.LoginRequest;
import com.toeic.demo.dto.request.RegisterRequest;
import com.toeic.demo.dto.response.AuthResponse;
import com.toeic.demo.entity.AppUser;
import com.toeic.demo.repository.AppUserRepository;
import com.toeic.demo.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public AuthResponse register(RegisterRequest request) {
        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        appUserRepository.save(user);

        return new AuthResponse(
                "Register success",
                user.getEmail(),
                user.getRole().name()
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        AppUser user = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return new AuthResponse(
                "Login success",
                user.getEmail(),
                user.getRole().name()
        );
    }
}
