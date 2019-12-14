package com.kahloun.api.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kahloun.api.mapping.SignInInput;
import com.kahloun.api.mapping.UserInput;
import com.kahloun.api.mapping.UserResponse;
import com.kahloun.api.mapping.UsersListResponse;
import com.kahloun.api.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@CrossOrigin()
	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	@ApiOperation(value = "\nAdd new User,The password will be generated automatically and will be sent to user by email \n", notes = "\nCode 1 : User Saved successfully.\n"
			+ "\n Code -1 : User already exists.\n", response = UserResponse.class)
	public UserResponse addNewUser(@Valid @RequestBody UserInput userInput) {
		return userService.addNewUser(userInput);
	}

	@CrossOrigin()
	@RequestMapping(value = "/users/all", method = RequestMethod.POST)
	@ApiOperation(value = "\nGet All Users\n", notes = "\nCode 1 : Get All Users successfully.\n"
			+ "\n Code -1 : Error occurred.\n", response = UsersListResponse.class)
	public UsersListResponse getAllQuestions() {
		return userService.getAllUsers();
	}

	@CrossOrigin()
	@RequestMapping(value = "/users/signin", method = RequestMethod.POST)
	@ApiOperation(value = "\nSignIn\n", notes = "\nCode 1 : User signed successfully.\n"
			+ "\n Code -1 : Wrong email or password.\n", response = UserResponse.class)
	public UserResponse signIn(@Valid @RequestBody SignInInput sinInInput) {
		return userService.signIn(sinInInput);
	}

}
