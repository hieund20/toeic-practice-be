package com.toeic.demo.controller;

import com.toeic.demo.dto.request.CreateUserRequest;
import com.toeic.demo.dto.response.UserResponse;
import com.toeic.demo.service.implement.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest req) {
        return userService.create(req);
    }

    @GetMapping("/{id}")
    public UserResponse getById(
            @PathVariable UUID id
    ) {
        return userService.getById(id);
    }
}
