package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPackageType {

	@JsonProperty
	private Integer id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String color;
	
	@JsonProperty
	private Date createdAt;
	
	@JsonProperty
	private Date updatedAt;
	
	@JsonProperty
	private Boolean isDefault;
	
	@JsonProperty
	private Boolean isMilestone;
	
	@JsonProperty("_links")
	private LinkCollection links;
	
	public WorkPackageType() {}

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Boolean getIsMilestone() {
		return isMilestone;
	}

	public void setIsMilestone(Boolean isMilestone) {
		this.isMilestone = isMilestone;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LinkCollection getLinks() {
		return links;
	}

	public void setLinks(LinkCollection links) {
		this.links = links;
	}
	
}
