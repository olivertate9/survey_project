package com.example.survey.service;

import com.example.survey.dto.MyAnswerDto;
import com.example.survey.dto.QuestionDto;
import com.example.survey.entity.MyAnswers;
import com.example.survey.exceptions.QuestionsNotFoundException;
import com.example.survey.repository.MyAnswersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyAnswersService {

    private final MyAnswersRepository myAnswersRepository;
    private final QuestionService questionService;

    public MyAnswerDto sendAnswer(String answer) {
        QuestionDto lastSeeingQuestion = questionService.getLastSeenQuestion();

        if (lastSeeingQuestion == null) {
            throw new QuestionsNotFoundException("No questions left");
        }

        MyAnswerDto myAnswerDto = new MyAnswerDto();
        myAnswerDto.setId(lastSeeingQuestion.getId());
        myAnswerDto.setAnswer(answer);

        myAnswersRepository.sendAnswer(lastSeeingQuestion.getId(), answer);
        questionService.removeFromAllQuestions(lastSeeingQuestion.getId());

        return myAnswerDto;
    }

    public MyAnswerDto changeAnswer(Long id, String answer) {

        MyAnswerDto myAnswerDto = new MyAnswerDto();
        myAnswerDto.setId(id);
        myAnswerDto.setAnswer(answer);

        myAnswersRepository.changeAnswer(id, answer);

        return myAnswerDto;
    }

    public Iterable<MyAnswers> findAll() {
        return myAnswersRepository.findAll();
    }
}
