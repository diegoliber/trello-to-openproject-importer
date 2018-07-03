package com.github.dieogoliber.openproject.trelloimporter.integration.trello.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Board {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	public Board() {
		
	}

	@JsonCreator
	public Board(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
