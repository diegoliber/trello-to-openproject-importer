package com.github.dieogoliber.openproject.trelloimporter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Account {

	@Id
	@Column
	@JsonProperty
	private String username;

	@Column
	@JsonProperty
	private String trelloId;

	@Column
	@JsonProperty
	private String fullName;
	
	@Column(unique = true)
	@JsonProperty
	private String trelloToken;
	
	@Column
	@JsonProperty
	private String openProjectToken;
	
	public Account() {}
	
	@JsonCreator
	public Account(
		@JsonProperty("username") String username, 
		@JsonProperty("id") String trelloId, 
		@JsonProperty("fullName") String fullName) {

		this.username = username;
		this.trelloId = trelloId;
		this.fullName = fullName;
	}

	public String getTrelloToken() {
		return trelloToken;
	}

	public void setTrelloToken(String trelloToken) {
		this.trelloToken = trelloToken;
	}

	public String getOpenProjectToken() {
		return openProjectToken;
	}

	public void setOpenProjectToken(String openProjectToken) {
		this.openProjectToken = openProjectToken;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the trelloId
	 */
	public String getTrelloId() {
		return trelloId;
	}

	/**
	 * @param trelloId the trelloId to set
	 */
	public void setTrelloId(String trelloId) {
		this.trelloId = trelloId;
	}
}
