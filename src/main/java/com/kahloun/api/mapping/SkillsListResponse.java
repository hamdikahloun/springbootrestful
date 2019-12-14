package com.kahloun.api.mapping;

import java.util.List;

import com.kahloun.api.model.Skill;

public class SkillsListResponse {
	private int code;
	private String error;
	private List<Skill> data;

	public SkillsListResponse(int code, String error, List<Skill> data) {
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

	public List<Skill> getData() {
		return data;
	}

	public void setData(List<Skill> data) {
		this.data = data;
	}

}
