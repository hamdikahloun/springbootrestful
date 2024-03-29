package com.kahloun.api.service;

import com.kahloun.api.mapping.SignInInput;
import com.kahloun.api.mapping.UserInput;
import com.kahloun.api.mapping.UserResponse;
import com.kahloun.api.mapping.UsersListResponse;

public interface UserServiceInterface {
	UserResponse addNewUser(UserInput userInput);

	UserResponse signIn(SignInInput sinInInput);

	UsersListResponse getAllUsers();

	void sendCredentialsEmail(String email, String password);

	String generateRandomString(int length);
}
