package com.example.survey.controller;

import com.example.survey.dto.QuestionDto;
import com.example.survey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/questions")
public class QuestionController {

    private final QuestionService service;

    @GetMapping("/random")
    public ResponseEntity<QuestionDto> retrieveRandomQuestion() {
        QuestionDto questionDto = service.retrieveRandomQuestion();
        return ResponseEntity.ok().body(questionDto);
    }

}
