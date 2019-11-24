package com.kahloun.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahloun.api.mapping.QuestionInput;
import com.kahloun.api.mapping.QuestionListResponse;
import com.kahloun.api.mapping.QuestionResponse;
import com.kahloun.api.model.Question;
import com.kahloun.api.repository.QuestionsRepository;

@Service
public class QuestionsService implements QuestionServiceInterface {

	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public QuestionResponse addNewQuestion(QuestionInput questionInput) {
		Question question = new Question(questionInput.getQuestion());
		Question questionSaved = questionsRepository.saveAndFlush(question);
		QuestionResponse questionResponse = new QuestionResponse(1, null, questionSaved);
		return questionResponse;
	}

	@Override
	public QuestionListResponse getAllQuestions() {
		List<Question> questions = questionsRepository.findAll();
		QuestionListResponse questionListResponse = new QuestionListResponse(1, null, questions);
		return questionListResponse;
	}

}
