package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	
	@JsonProperty
	private Integer id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty("_links")
	private LinkCollection links;

	public Category() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkCollection getLinks() {
		return links;
	}

	public void setLinks(LinkCollection links) {
		this.links = links;
	}
	
}
