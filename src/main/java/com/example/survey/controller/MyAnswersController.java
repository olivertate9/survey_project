package com.example.survey.controller;

import com.example.survey.dto.MyAnswerDto;
import com.example.survey.entity.MyAnswers;
import com.example.survey.service.MyAnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/answers")
@RequiredArgsConstructor
public class MyAnswersController {

    private final MyAnswersService myAnswersService;

    @PostMapping("")
    public ResponseEntity<MyAnswerDto> sendAnswer(@RequestBody MyAnswerDto answer) {
        myAnswersService.sendAnswer(answer.getId(), answer.getAnswer());
        return ResponseEntity.ok().body(answer);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics() {
        Iterable<MyAnswers> all = myAnswersService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PatchMapping("/change")
    public ResponseEntity<MyAnswerDto> changeAnswer(@RequestBody MyAnswerDto answer) {
        myAnswersService.changeAnswer(answer.getId(), answer.getAnswer());
        return ResponseEntity.ok().body(answer);
    }
}
