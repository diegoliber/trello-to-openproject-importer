package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectCategory {
	
	@JsonProperty
	private Integer id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty("_link")
	private LinkCollection links;
	
	public ProjectCategory() {
		this.links = new LinkCollection();
	}

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
	
}
