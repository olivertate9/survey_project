package com.example.survey.controller;

import com.example.survey.dto.QuestionDto;
import com.example.survey.exceptions.QuestionsNotFoundException;
import com.example.survey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService service;

    @GetMapping("/random")
    public ResponseEntity<?> retrieveRandomQuestion() {
        try {
            QuestionDto questionDto = service.retrieveRandomQuestion();
            return ResponseEntity.ok().body(questionDto);
        } catch (QuestionsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
