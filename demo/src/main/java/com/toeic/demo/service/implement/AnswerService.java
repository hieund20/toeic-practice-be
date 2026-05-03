package com.toeic.demo.service.implement;

import com.toeic.demo.dto.request.AnswerRequest;
import com.toeic.demo.dto.response.AnswerResponse;
import com.toeic.demo.entity.Answer;
import com.toeic.demo.entity.Question;
import com.toeic.demo.repository.AnswerRepository;
import com.toeic.demo.repository.QuestionRepository;
import com.toeic.demo.service.IAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public AnswerResponse create(AnswerRequest req) {
        Question question = questionRepository.findById(req.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Answer a = new Answer();
        a.setQuestion(question);
        a.setContent(req.getContent());
        a.setIsCorrect(req.getIsCorrect());
        a.setAnswerOrder(req.getAnswerOrder());

        return map(answerRepository.save(a));
    }

    @Override
    public List<AnswerResponse> getByQuestion(UUID questionId) {
        return answerRepository.findByQuestionId(questionId)
                .stream().map(this::map).toList();
    }

    @Override
    public void delete(UUID id) {
        answerRepository.deleteById(id);
    }

    @Override
    public AnswerResponse getById(UUID id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        return map(answer);
    }

    @Override
    public AnswerResponse update(UUID id, AnswerRequest req) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        answer.setContent(req.getContent());
        answer.setIsCorrect(req.getIsCorrect());
        answer.setAnswerOrder(req.getAnswerOrder());

        answerRepository.save(answer);

        return map(answer);
    }

    private AnswerResponse map(Answer a) {
        return new AnswerResponse(
                a.getId(),
                a.getContent(),
                a.getAnswerOrder(),
                a.getQuestion().getId(),
                a.getIsCorrect()
        );
    }
}
