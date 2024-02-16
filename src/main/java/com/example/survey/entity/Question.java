package com.example.survey.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Question {
    @Id
    private Long id;
    private String name;
}
