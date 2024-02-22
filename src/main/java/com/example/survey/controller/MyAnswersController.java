package com.example.survey.controller;

import com.example.survey.dto.MyAnswerDto;
import com.example.survey.entity.MyAnswers;
import com.example.survey.service.MyAnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions/")
@RequiredArgsConstructor
public class MyAnswersController {

    private final MyAnswersService myAnswersService;

    @PostMapping("/send")
    public ResponseEntity<MyAnswerDto> sendAnswer(@RequestParam String answer) {
        MyAnswerDto myAnswerDto = myAnswersService.sendAnswer(answer);
        return ResponseEntity.ok().body(myAnswerDto);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics() {
        Iterable<MyAnswers> all = myAnswersService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PatchMapping("/change")
    public ResponseEntity<MyAnswerDto> changeAnswer(@RequestParam Long id, @RequestParam String answer) {
        MyAnswerDto myAnswerDto = myAnswersService.changeAnswer(id, answer);
        return ResponseEntity.ok().body(myAnswerDto);
    }
}
