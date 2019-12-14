package com.kahloun.api.service;

import com.kahloun.api.mapping.SkillInput;
import com.kahloun.api.mapping.SkillsListResponse;
import com.kahloun.api.mapping.SkillsResponse;

public interface SkillsServiceInterface {
	SkillsResponse addNewSkill(SkillInput skillInput);

	SkillsListResponse getAllSkills();
}
