package com.kahloun.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skill_id;
	private String skill;
	private Date creation_date = new Date();

	public Skill() {

	}

	public Skill(String skill) {
		this.skill = skill;
	}

	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}

}
