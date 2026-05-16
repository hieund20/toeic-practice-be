package com.toeic.demo.controller;

import com.toeic.demo.dto.response.TestAttemptResponse;
import com.toeic.demo.service.ITestAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/test-attempts")
@RequiredArgsConstructor
public class TestAttemptController {

    private final ITestAttemptService service;

    @GetMapping("/user/{userId}")
    public List<TestAttemptResponse> getHistory(
            @PathVariable UUID userId
    ) {
        return service.getHistoryByUser(userId);
    }
}
