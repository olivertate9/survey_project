package com.example.survey.repository;

import com.example.survey.entity.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Query("SELECT * FROM Question")
    List<Question> findAll();
}
