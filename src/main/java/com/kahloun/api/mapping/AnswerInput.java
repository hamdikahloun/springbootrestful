package com.kahloun.api.mapping;

public class AnswerInput {
	private int answer;
	private String description;
	private int skill_id;
	private int user_id;

	public AnswerInput(int answer, int skill_id, int user_id, String description) {
		this.answer = answer;
		this.description = description;
		this.skill_id = skill_id;
		this.user_id = user_id;
	}

	public int getAnswer() {
		return answer;
	}

	public AnswerInput() {

	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
