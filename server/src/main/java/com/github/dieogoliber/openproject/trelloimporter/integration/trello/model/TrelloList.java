package com.github.dieogoliber.openproject.trelloimporter.integration.trello.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrelloList {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;

	public TrelloList() {
		
	}
	
	public TrelloList(String id, String name) {
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
