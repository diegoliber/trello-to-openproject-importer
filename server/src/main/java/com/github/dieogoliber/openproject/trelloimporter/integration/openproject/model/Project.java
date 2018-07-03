package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("identifier")
	private String identifier;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("_links")
	private LinkCollection links;

	public Project() {
		super();
		this.links = new LinkCollection();
	}

	public Project(String id, String identifier, String name, String description) {
		this();
		this.id = id;
		this.identifier = identifier;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
