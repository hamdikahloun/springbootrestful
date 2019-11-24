package com.kahloun.api.mapping;

import java.util.List;

import com.kahloun.api.model.User;

public class UsersListResponse {
	private int code;
	private String error;
	private List<User> data;

	public UsersListResponse(int code, String error, List<User> data) {
		this.code = code;
		this.error = error;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

}
