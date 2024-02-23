package com.example.survey.controller;

import com.example.survey.exceptions.QuestionsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(QuestionsNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> questionsNotFoundException(Exception e){
        HashMap<String,String> response = new HashMap<>();
        response.put("Error", e.getMessage());
        response.put("ErrorCode", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
