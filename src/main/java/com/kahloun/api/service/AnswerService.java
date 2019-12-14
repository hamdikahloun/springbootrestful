package com.kahloun.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahloun.api.mapping.AnswerInput;
import com.kahloun.api.mapping.AnswerResponse;
import com.kahloun.api.mapping.AnswersListResponse;
import com.kahloun.api.mapping.SkillsListInput;
import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Skill;
import com.kahloun.api.model.User;
import com.kahloun.api.repository.AnswerRepository;
import com.kahloun.api.repository.SkillsRepository;
import com.kahloun.api.repository.UserRepository;

@Service
public class AnswerService implements AnswerServiceInterface {

	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private SkillsRepository skillsRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public AnswerResponse addNewAnswer(AnswerInput answerInput) {
		System.out.print("addNewAnswer ==> Answer : " + answerInput.getAnswer() + " Skill ID: "
				+ answerInput.getSkill_id() + "\n");
		Optional<Skill> skOptional = checkSkill(answerInput.getSkill_id());
		if (!skOptional.isPresent()) {
			return new AnswerResponse(-1, "Wrong Skill ID", null);
		}
		Optional<User> user = userRepository.findById(answerInput.getUser_id());
		if (!user.isPresent()) {
			return new AnswerResponse(-2, "Wrong User ID", null);
		}
		Optional<Answer> optionalAnswer = answerRepository.findBySkillAndUser(skOptional.get(), user.get());
		if (optionalAnswer.isPresent()) {
			return new AnswerResponse(-3, "Skill already answered", null);
		}
		Answer answer = new Answer(answerInput.getAnswer(), skOptional.get(), user.get());
		Answer answerSaved = answerRepository.saveAndFlush(answer);
		return new AnswerResponse(1, null, answerSaved);
	}

	@Override
	public AnswerResponse updateAnswer(Answer answer) {

		if (answer == null) {
			return new AnswerResponse(-1, "Wrong Answer Value", null);
		}
		System.out.print("updateAnswer ==> Answer ID: " + answer.getAnswer_id() + "\n");
		Optional<Skill> skOptional = checkSkill(answer.getSkill().getSkill_id());
		if (!skOptional.isPresent()) {
			return new AnswerResponse(-1, "Wrong Skill ID", null);
		}

		Answer answerSaved = answerRepository.saveAndFlush(answer);
		return new AnswerResponse(1, null, answerSaved);
	}

	@Override
	public AnswersListResponse findAnswersByUser(SkillsListInput skillsListInput) {
		System.out.print("findAnswersByUser ==> User ID: " + skillsListInput.getUser_id() + "\n");

		Optional<User> user = userRepository.findById(skillsListInput.getUser_id());
		if (!user.isPresent()) {
			return new AnswersListResponse(-2, "Wrong User ID", null);
		}

		List<Answer> answers = answerRepository.findByUser(user.get());
		return new AnswersListResponse(1, null, answers);
	}

	@Override
	public Optional<Skill> checkSkill(int skill_id) {
		System.out.print("checkSkill ==> skill ID: " + skill_id + "\n");
		Optional<Skill> skOptional = skillsRepository.findById(skill_id);

		if (!skOptional.isPresent()) {
			return null;
		}

		return skOptional;
	}
}
