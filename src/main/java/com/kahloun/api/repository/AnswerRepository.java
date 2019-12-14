package com.kahloun.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Skill;
import com.kahloun.api.model.User;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	List<Answer> findBySkillAndUser(Skill skill, User user);

}
