package com.toeic.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PartResponse {
    private UUID id;
    private Integer partNumber;
    private List<QuestionResponse> questions;
    private List<GroupResponse> groups;
}
