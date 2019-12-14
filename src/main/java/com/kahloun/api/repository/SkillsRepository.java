package com.kahloun.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.Skill;

public interface SkillsRepository extends JpaRepository<Skill, Integer> {
}
