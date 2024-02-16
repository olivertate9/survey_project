package com.example.survey.service;

import com.example.survey.repository.AnswerRepository;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.dto.QuestionDto;
import com.example.survey.entity.Question;
import com.example.survey.exceptions.QuestionsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionDto retrieveRandomQuestion() {

        List<Question> all = getQuestions();

        if (all.isEmpty()) {
            throw new QuestionsNotFoundException("No questions left");
        }

        int randomIndex = getRandomIndex(all);

        Long id = all.get(randomIndex).getId();
        String name = all.get(randomIndex).getName();
        List<String> answers = answerRepository.findAllByQuestionId(id);

        answerRepository.deleteByQuestionId(id);
        questionRepository.deleteById(id);

        return getQuestionDto(all, randomIndex, name, answers);
    }

    private static QuestionDto getQuestionDto(List<Question> all, int randomIndex, String name, List<String> answers) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(all.get(randomIndex).getId());
        questionDto.setName(name);
        questionDto.setAnswers(answers);
        return questionDto;
    }

    private static int getRandomIndex(List<Question> all) {
        Random random = new Random();
        return random.nextInt(all.size());
    }

    private List<Question> getQuestions() {
        Iterable<Question> allIterable = questionRepository.findAll();
        return StreamSupport.stream(allIterable.spliterator(), false).collect(Collectors.toList());
    }


}
