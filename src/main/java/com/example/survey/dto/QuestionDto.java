package com.example.survey.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {
    private Long id;
    private String name;
    private List<String> answers;
}
