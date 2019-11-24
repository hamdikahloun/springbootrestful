package com.kahloun.api.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kahloun.api.mapping.QuestionInput;
import com.kahloun.api.mapping.QuestionListResponse;
import com.kahloun.api.mapping.QuestionResponse;
import com.kahloun.api.service.QuestionsService;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
public class QuestionsEndpoint {

	@Autowired
	private QuestionsService questionsService;

	@CrossOrigin()
	@RequestMapping(value = "/questions/new", method = RequestMethod.POST)
	@ApiOperation(value = "\nAdd new question\n", notes = "\nCode 1 : Question Saved successfully.\n"
			+ "\n Code -1 : Error occurred.\n", response = QuestionResponse.class)
	public QuestionResponse addNewQuestion(@Valid @RequestBody QuestionInput question) {
		return questionsService.addNewQuestion(question);
	}

	@CrossOrigin()
	@RequestMapping(value = "/questions/all", method = RequestMethod.POST)
	@ApiOperation(value = "\nGet All Questions\n", notes = "\nCode 1 : Get All Questions successfully.\n"
			+ "\n Code -1 : Error occurred.\n", response = QuestionListResponse.class)
	public QuestionListResponse getAllQuestions() {
		return questionsService.getAllQuestions();
	}
}
