package com.example.survey.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("MyAnswers")
public class MyAnswers {
    @Id
    private Long id;
    private String answer;
}
