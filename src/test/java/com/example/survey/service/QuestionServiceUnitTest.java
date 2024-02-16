package com.example.survey.service;

import com.example.survey.repository.AnswerRepository;
import com.example.survey.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class QuestionServiceUnitTest {

    @Test
    @DisplayName("Test the random question is generated if no exception")
    public void questionServiceRandomIsGenerated() {
        QuestionRepository questionRepository = mock(QuestionRepository.class);
        AnswerRepository answerRepository = mock(AnswerRepository.class);

        QuestionService questionService = new QuestionService(questionRepository, answerRepository);


    }
}
