package com.kahloun.api.mapping;

public class SkillsIDInput {
	private int skill_id;
	private int user_id;

	public SkillsIDInput(int skill_id, int user_id) {
		this.skill_id = skill_id;
		this.user_id = user_id;
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
}
