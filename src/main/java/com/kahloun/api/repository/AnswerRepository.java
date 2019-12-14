package com.kahloun.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Skill;
import com.kahloun.api.model.User;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	Optional<Answer> findBySkillAndUser(Skill skill, User user);
	List<Answer> findByUser(User user);
}
