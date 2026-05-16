package com.toeic.demo.service.implement;

import com.toeic.demo.dto.response.TestAttemptResponse;
import com.toeic.demo.entity.TestAttempt;
import com.toeic.demo.repository.TestAttemptRepository;
import com.toeic.demo.service.ITestAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestAttemptService implements ITestAttemptService {

    private final TestAttemptRepository repository;

    @Override
    public List<TestAttemptResponse> getHistoryByUser(UUID userId) {
        List<TestAttempt> attempts =
                repository.findByUserIdOrderBySubmittedAtDesc(userId);

        return attempts.stream()
                .map(this::mapToResponse)
                .toList();
    }

    private TestAttemptResponse mapToResponse(
            TestAttempt attempt
    ) {
        return new TestAttemptResponse(
                attempt.getId(),
                attempt.getTest().getTitle(),
                attempt.getScore(),
                attempt.getStartedAt(),
                attempt.getSubmittedAt(),
                attempt.getUserId()
        );
    }
}
