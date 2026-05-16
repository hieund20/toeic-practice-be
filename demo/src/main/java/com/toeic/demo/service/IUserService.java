package com.toeic.demo.service;

import com.toeic.demo.dto.request.CreateUserRequest;
import com.toeic.demo.dto.response.UserResponse;

import java.util.UUID;

public interface IUserService {
    UserResponse create(CreateUserRequest req);

    UserResponse getById(UUID id);
}
