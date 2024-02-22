package com.example.survey.service;

import com.example.survey.dto.QuestionDto;
import com.example.survey.entity.Question;
import com.example.survey.repository.AnswerRepository;
import com.example.survey.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    void testRetrieveRandomQuestion() {
        List<Question> mockQuestions = new ArrayList<>();
        List<String> mockAnswers = Arrays.asList("Answer 1", "Answer 2", "Answer 3");

        Question question = new Question();
        Long id = 1L;
        String name = "Question 1";
        question.setId(id);
        question.setName(name);
        mockQuestions.add(question);

        given(questionRepository.findAll()).willReturn(mockQuestions);
        given(answerRepository.findAllByQuestionId(id)).willReturn(mockAnswers);

        questionService.initializeQuestions();

        QuestionDto lastSeeingQuestion = questionService.retrieveRandomQuestion();

        assertNotNull(lastSeeingQuestion);
        assertEquals(mockQuestions.size(), 1);
        assertEquals(lastSeeingQuestion.getId(), id);
        assertEquals(lastSeeingQuestion.getName(), name);
        assertEquals(lastSeeingQuestion.getAnswers(), mockAnswers);

        verify(questionRepository, times(1)).findAll();
        verify(answerRepository, times(1)).findAllByQuestionId(id);
    }
}

