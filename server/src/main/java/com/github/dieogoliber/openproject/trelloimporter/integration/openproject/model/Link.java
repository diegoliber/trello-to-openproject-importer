package com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
	
	@JsonProperty("href")
	private String href;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("method")
	private String method;
	
	public Link() { }

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
