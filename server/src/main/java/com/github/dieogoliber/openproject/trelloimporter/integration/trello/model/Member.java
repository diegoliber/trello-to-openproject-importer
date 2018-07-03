package com.github.dieogoliber.openproject.trelloimporter.integration.trello.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {

	@JsonProperty("id")
	private String id;

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("fullName")
	private String fullName;
	
	public Member() {
		
	}

	@JsonCreator
	public Member(@JsonProperty("id") String id, @JsonProperty("username") String username, @JsonProperty("fullName") String fullName) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
