package com.kahloun.api.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kahloun.api.mapping.AnswerInput;
import com.kahloun.api.mapping.AnswerResponse;
import com.kahloun.api.mapping.AnswersListResponse;
import com.kahloun.api.mapping.QuestionIDInput;
import com.kahloun.api.model.Answer;
import com.kahloun.api.service.AnswerService;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
public class AnswersEndpoint {

	@Autowired
	private AnswerService answerService;

	@CrossOrigin()
	@RequestMapping(value = "/answers/new", method = RequestMethod.POST)
	@ApiOperation(value = "\nAdd new Answer for specific Question and User\n", notes = "\nCode 1 : Answer Saved successfully.\n"
			+ "\n Code -1 : Wrong Question ID.\n" + "\n Code -2 : Wrong User ID.\n", response = AnswerResponse.class)
	public AnswerResponse addNewAnswer(@Valid @RequestBody AnswerInput answer) {
		return answerService.addNewAnswer(answer);
	}

	@CrossOrigin()
	@RequestMapping(value = "/answers/update", method = RequestMethod.POST)
	@ApiOperation(value = "\nUpdate Answer\n", notes = "\nCode 1 : Answer Updated successfully.\n"
			+ "\n Code -1 : Wrong Question ID.\n", response = AnswerResponse.class)
	public AnswerResponse updateAnswer(@Valid @RequestBody Answer answer) {
		return answerService.updateAnswer(answer);
	}

	@CrossOrigin()
	@RequestMapping(value = "/answers/getanswersbyquestionanduser", method = RequestMethod.POST)
	@ApiOperation(value = "\nGet Answers list by question and user\n", notes = "\nCode 1 : Get Answers successfully.\n"
			+ "\n Code -1 : Wrong Question ID.\n"
			+ "\n Code -2 : Wrong User ID.\n", response = AnswersListResponse.class)
	public AnswersListResponse findAnswersByQuestionAndUser(@Valid @RequestBody QuestionIDInput questionIDInput) {
		return answerService.findAnswersByQuestionAndUser(questionIDInput);
	}
}
