package com.kahloun.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahloun.api.mapping.AnswerInput;
import com.kahloun.api.mapping.AnswerResponse;
import com.kahloun.api.mapping.AnswersListResponse;
import com.kahloun.api.mapping.QuestionIDInput;
import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Question;
import com.kahloun.api.model.User;
import com.kahloun.api.repository.AnswerRepository;
import com.kahloun.api.repository.QuestionsRepository;
import com.kahloun.api.repository.UserRepository;

@Service
public class AnswerService implements AnswerServiceInterface {

	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionsRepository questionsRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public AnswerResponse addNewAnswer(AnswerInput answerInput) {
		System.out.print("addNewAnswer ==> Answer : " + answerInput.getAnswer() + " Question ID: "+answerInput.getQuestion_id()+"\n");
		Optional<Question> question = checkQuestion(answerInput.getQuestion_id());
		if (!question.isPresent()) {
			return new AnswerResponse(-1, "Wrong Question ID", null);
		}
		Optional<User> user = userRepository.findById(answerInput.getUser_id());
		if (!user.isPresent()) {
			return new AnswerResponse(-2, "Wrong User ID", null);
		}
		Answer answer = new Answer(answerInput.getAnswer(), question.get(), user.get());
		Answer answerSaved = answerRepository.saveAndFlush(answer);
		return new AnswerResponse(1, null, answerSaved);
	}

	@Override
	public AnswerResponse updateAnswer(Answer answer) {
		
		if (answer == null) {
			return new AnswerResponse(-1, "Wrong Answer Value", null);
		}
		System.out.print("updateAnswer ==> Answer ID: " + answer.getAnswer_id() + "\n");
		Optional<Question> question = checkQuestion(answer.getQuestion().getQuestion_id());
		if (!question.isPresent()) {
			return new AnswerResponse(-1, "Wrong Question ID", null);
		}
		
		Answer answerSaved = answerRepository.saveAndFlush(answer);
		return new AnswerResponse(1, null, answerSaved);
	}

	@Override
	public AnswersListResponse findAnswersByQuestionAndUser(QuestionIDInput questionIDInput) {
		System.out.print("findAnswersByQuestionAndUser ==> Question ID: " + questionIDInput.getQuestion_id() + "\n");
		Optional<Question> question = checkQuestion(questionIDInput.getQuestion_id());
		if (!question.isPresent()) {
			return new AnswersListResponse(-1, "Wrong Question ID", null);
		}
		Optional<User> user = userRepository.findById(questionIDInput.getUser_id());
		if (!user.isPresent()) {
			return new AnswersListResponse(-2, "Wrong User ID", null);
		}

		List<Answer> answers = answerRepository.findByQuestionAndUser(question.get(), user.get());
		return new AnswersListResponse(1, null, answers);
	}

	@Override
	public Optional<Question> checkQuestion(int question_id) {
		System.out.print("checkQuestion ==> Question ID: " + question_id + "\n");
		Optional<Question> question = questionsRepository.findById(question_id);

		if (question == null) {
			return null;
		}

		return question;
	}
}
