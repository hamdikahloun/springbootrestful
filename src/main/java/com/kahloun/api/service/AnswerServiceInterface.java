package com.kahloun.api.service;

import java.util.Optional;

import com.kahloun.api.mapping.AnswerInput;
import com.kahloun.api.mapping.AnswerResponse;
import com.kahloun.api.mapping.AnswersListResponse;
import com.kahloun.api.mapping.SkillsIDInput;
import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Skill;

public interface AnswerServiceInterface {
	AnswerResponse addNewAnswer(AnswerInput answerInput);

	AnswerResponse updateAnswer(Answer answer);

	AnswersListResponse findAnswersBySkillAndUser(SkillsIDInput skillsIDInput);

	Optional<Skill> checkSkill(int skill_id);
}
