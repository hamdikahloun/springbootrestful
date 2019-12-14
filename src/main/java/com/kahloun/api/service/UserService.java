package com.kahloun.api.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kahloun.api.mapping.SignInInput;
import com.kahloun.api.mapping.UserInput;
import com.kahloun.api.mapping.UserResponse;
import com.kahloun.api.mapping.UsersListResponse;
import com.kahloun.api.model.User;
import com.kahloun.api.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";

	private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	private static SecureRandom random = new SecureRandom();

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public UserResponse addNewUser(UserInput userInput) {
		User user = userRepository.findOneByEmail(userInput.getEmail());
		if (user != null) {
			return new UserResponse(-1, "User already exists", null);
		}
		String password = generateRandomString(8);
		User userToSave = new User(userInput.getEmail(), password, userInput.getName());
		User userSaved = userRepository.saveAndFlush(userToSave);
		sendCredentialsEmail(userInput.getEmail(), password);
		UserResponse userResponse = new UserResponse(1, null, userSaved);
		return userResponse;
	}

	@Override
	public UserResponse signIn(SignInInput sinInInput) {
		User user = userRepository.findOneByEmailAndPassword(sinInInput.getEmail(), sinInInput.getPassword());
		if (user == null) {
			return new UserResponse(-1, "Wrong email or password", null);
		}

		UserResponse userResponse = new UserResponse(1, null, user);
		return userResponse;
	}

	@Override
	public UsersListResponse getAllUsers() {
		List<User> users = userRepository.findAll();
		UsersListResponse usersListResponse = new UsersListResponse(1, null, users);
		return usersListResponse;
	}

	@Override
	public void sendCredentialsEmail(String email, String password) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("Credentials");
		msg.setText("Hello; \nPlease use this credentials for Skill application :\n" + "Email: " + email + "\n"
				+ "Password: " + password + "\n");

		javaMailSender.send(msg);

	}

	@Override
	public String generateRandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			// 0-62 (exclusive), random returns 0-61
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

			// debug
			System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

			sb.append(rndChar);

		}

		return sb.toString();
	}

}
