package com.kahloun.api.mapping;

import java.util.List;

import com.kahloun.api.model.Answer;

public class AnswersListResponse {
	private int code;
	private String error;
	private List<Answer> data;

	public AnswersListResponse(int code, String error, List<Answer> data) {
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

	public List<Answer> getData() {
		return data;
	}

	public void setData(List<Answer> data) {
		this.data = data;
	}

}
