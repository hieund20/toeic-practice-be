package com.toeic.demo.service;

import com.toeic.demo.dto.response.TestAttemptResponse;

import java.util.List;
import java.util.UUID;

public interface ITestAttemptService {
    List<TestAttemptResponse> getHistoryByUser(UUID userId);
}
