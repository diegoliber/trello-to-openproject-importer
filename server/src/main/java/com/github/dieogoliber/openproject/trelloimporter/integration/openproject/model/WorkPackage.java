package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkPackage {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("lockVersion")
	private Integer lockVersion;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("description")
	private Description description;
	
	@JsonProperty("startDate")
	@JsonFormat(shape = Shape.STRING, pattern = Constants.DATE_FORMAT_SIMPLE_STR)
	private Date startDate;
	
	@JsonProperty("dueDate")
	@JsonFormat(shape = Shape.STRING, pattern = Constants.DATE_FORMAT_SIMPLE_STR)
	private Date dueDate;
	
	@JsonProperty("createdAt")
	@JsonFormat(shape = Shape.STRING, pattern = Constants.DATE_FORMAT_ISO_STR)
	private Date createdAt;
	
	@JsonProperty("updatedAt")
	@JsonFormat(shape = Shape.STRING, pattern = Constants.DATE_FORMAT_ISO_STR)
	private Date updatedAt;
	
	@JsonProperty("_links")
	private LinkCollection links;

	public WorkPackage() {
		links = new LinkCollection();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Integer lockVersion) {
		this.lockVersion = lockVersion;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
