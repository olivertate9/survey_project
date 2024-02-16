package com.example.survey.repository;

import com.example.survey.entity.MyAnswers;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MyAnswersRepository extends CrudRepository<MyAnswers, Long> {

    @Modifying
    @Query("INSERT INTO MyAnswers (id, answer) VALUES (:id, :answer)")
    void sendAnswer(long id, String answer);

    @Modifying
    @Query("UPDATE MyAnswers SET answer = :answer WHERE id =:id")
    void changeAnswer(long id, String answer);
}
