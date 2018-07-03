package com.github.dieogoliber.openproject.trelloimporter.integration.trello.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Label {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("color")
	private String color;
	
	public Label() {
		
	}

	public Label(String id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
