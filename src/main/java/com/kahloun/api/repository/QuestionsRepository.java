package com.kahloun.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.Question;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {
}
