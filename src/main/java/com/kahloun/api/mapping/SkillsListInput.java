package com.kahloun.api.mapping;

public class SkillsListInput {
	private int user_id;

	public SkillsListInput(int user_id) {
		this.user_id = user_id;
	}

	public SkillsListInput() {
		super();
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

}
