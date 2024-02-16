package com.example.survey.repository;

import com.example.survey.entity.Answer;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    @Modifying
    @Query("DELETE FROM answer WHERE questionId = :id")
    void deleteByQuestionId(Long id);

    @Query("SELECT answer_text FROM answer WHERE questionId = :id")
    List<String> findAllByQuestionId(Long id);
}
