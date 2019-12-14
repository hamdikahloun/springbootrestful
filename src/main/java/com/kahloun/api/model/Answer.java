package com.kahloun.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answer_id;
	private int answer;
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "skill_id")
	private Skill skill;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	private Date creation_date = new Date();

	public Answer() {

	}

	public Answer(int answer, Skill skill, User user) {
		this.answer = answer;
		this.skill = skill;
		this.user = user;
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
