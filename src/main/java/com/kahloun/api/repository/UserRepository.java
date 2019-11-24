package com.kahloun.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahloun.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByEmail(String email);

	User findOneByEmailAndPassword(String email, String password);

}
