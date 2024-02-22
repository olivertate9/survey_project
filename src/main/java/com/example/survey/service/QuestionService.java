package com.example.survey.service;

import com.example.survey.dto.QuestionDto;
import com.example.survey.entity.Question;
import com.example.survey.exceptions.QuestionsNotFoundException;
import com.example.survey.repository.AnswerRepository;
import com.example.survey.repository.QuestionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Getter
    private List<Question> allQuestions;
    @Getter
    private QuestionDto lastSeenQuestion;

    @PostConstruct
    public void initializeQuestions() {
        allQuestions = questionRepository.findAll();
    }

    public QuestionDto retrieveRandomQuestion() {

        if (allQuestions.isEmpty()) {
            throw new QuestionsNotFoundException("No questions left");
        }

        int randomIndex = getRandomIndex(allQuestions);

        Long id = allQuestions.get(randomIndex).getId();
        String name = allQuestions.get(randomIndex).getName();
        List<String> answers = answerRepository.findAllByQuestionId(id);

        lastSeenQuestion = getQuestionDto(id, name, answers);

        return lastSeenQuestion;
    }

    private static QuestionDto getQuestionDto(Long id, String name, List<String> answers) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(id);
        questionDto.setName(name);
        questionDto.setAnswers(answers);
        return questionDto;
    }

    private static int getRandomIndex(List<Question> all) {
        Random random = new Random();
        return random.nextInt(all.size());
    }

    public void removeFromAllQuestions(Long id) {
        allQuestions.removeIf(question -> question.getId().equals(id));
    }

}
