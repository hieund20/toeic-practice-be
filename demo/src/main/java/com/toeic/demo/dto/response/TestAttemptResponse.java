package com.toeic.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TestAttemptResponse {
    private UUID id;

    private String testName;

    private Integer score;

    private LocalDateTime startedAt;

    private LocalDateTime submittedAt;

    private UUID userId;
}
