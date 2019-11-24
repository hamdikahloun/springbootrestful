package com.kahloun.api.service;

import com.kahloun.api.mapping.QuestionInput;
import com.kahloun.api.mapping.QuestionListResponse;
import com.kahloun.api.mapping.QuestionResponse;

public interface QuestionServiceInterface {
	QuestionResponse addNewQuestion(QuestionInput questionInput);
	QuestionListResponse getAllQuestions();
}
