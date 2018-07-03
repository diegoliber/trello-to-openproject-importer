package com.github.dieogoliber.openproject.trelloimporter.integration.trello.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("desc")
	private String desc;
	
	@JsonProperty("labels")
	private List<Label> labels;
	
	public Card() {
		
	}

	public Card(String id, String name, String desc, List<Label> labels) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.labels = labels;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
}
