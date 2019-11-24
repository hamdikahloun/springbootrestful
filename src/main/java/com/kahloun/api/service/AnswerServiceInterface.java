package com.kahloun.api.service;

import java.util.Optional;

import com.kahloun.api.mapping.AnswerInput;
import com.kahloun.api.mapping.AnswerResponse;
import com.kahloun.api.mapping.AnswersListResponse;
import com.kahloun.api.mapping.QuestionIDInput;
import com.kahloun.api.model.Answer;
import com.kahloun.api.model.Question;

public interface AnswerServiceInterface {
	AnswerResponse addNewAnswer(AnswerInput answerInput);

	AnswerResponse updateAnswer(Answer answer);

	AnswersListResponse findAnswersByQuestionAndUser(QuestionIDInput questionIDInput);

	Optional<Question> checkQuestion(int question_id);
}
