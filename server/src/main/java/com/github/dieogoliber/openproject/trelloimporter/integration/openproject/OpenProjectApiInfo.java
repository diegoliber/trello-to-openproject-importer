package com.github.dieogoliber.openproject.trelloimporter.integration.openproject;

public class OpenProjectApiInfo {

	private String origin;
	private String apiRoot;

	public OpenProjectApiInfo(String origin, String apiRoot) {
		super();
		this.origin = origin;
		this.apiRoot = apiRoot;
	}

	public String getBaseUrl() {
		return origin + apiRoot;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getApiRoot() {
		return apiRoot;
	}

	public void setApiRoot(String apiRoot) {
		this.apiRoot = apiRoot;
	}
	
}
