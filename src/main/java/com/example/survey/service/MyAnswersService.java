package com.example.survey.service;

import com.example.survey.repository.MyAnswersRepository;
import com.example.survey.entity.MyAnswers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyAnswersService {

    private final MyAnswersRepository myAnswersRepository;

    public void sendAnswer(long id, String answer) {
        myAnswersRepository.sendAnswer(id, answer);
    }

    public void changeAnswer(long id, String answer) {
        myAnswersRepository.changeAnswer(id, answer);
    }

    public Iterable<MyAnswers> findAll() {
        return myAnswersRepository.findAll();
    }
}
