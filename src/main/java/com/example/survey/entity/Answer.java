package com.example.survey.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Answer {
    @Id
    private Long id;
    private String answer_text;
}
