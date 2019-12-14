package com.kahloun.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahloun.api.mapping.SkillInput;
import com.kahloun.api.mapping.SkillsListResponse;
import com.kahloun.api.mapping.SkillsResponse;
import com.kahloun.api.model.Skill;
import com.kahloun.api.repository.SkillsRepository;

@Service
public class SkillsService implements SkillsServiceInterface {

	@Autowired
	private SkillsRepository skillsRepository;

	@Override
	public SkillsResponse addNewSkill(SkillInput skillInput) {
		Skill skill = new Skill(skillInput.getSkill());
		Skill skillSaved = skillsRepository.saveAndFlush(skill);
		SkillsResponse skillsResponse = new SkillsResponse(1, null, skillSaved);
		return skillsResponse;
	}

	@Override
	public SkillsListResponse getAllSkills() {
		List<Skill> skills = skillsRepository.findAll();
		SkillsListResponse skillsListResponse = new SkillsListResponse(1, null, skills);
		return skillsListResponse;
	}

}
