package com.kahloun.api.mapping;

import java.util.List;

import com.kahloun.api.model.Question;

public class QuestionListResponse {
	private int code;
	private String error;
	private List<Question> data;

	public QuestionListResponse(int code, String error, List<Question> data) {
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

	public List<Question> getData() {
		return data;
	}

	public void setData(List<Question> data) {
		this.data = data;
	}

}
