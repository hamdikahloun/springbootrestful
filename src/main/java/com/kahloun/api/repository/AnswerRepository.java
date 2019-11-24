package com.kahloun.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Question;
import com.kahloun.api.model.User;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	List<Answer> findByQuestionAndUser(Question question, User user);

}
