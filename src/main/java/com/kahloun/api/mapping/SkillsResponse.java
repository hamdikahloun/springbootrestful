package com.kahloun.api.mapping;

import com.kahloun.api.model.Skill;

public class SkillsResponse {
	private int code;
	private String error;
	private Skill data;

	public SkillsResponse(int code, String error, Skill data) {
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

	public Skill getData() {
		return data;
	}

	public void setData(Skill data) {
		this.data = data;
	}

}
