package com.github.dieogoliber.openproject.trelloimporter.integration.trello;

import java.util.Properties;

public class TrelloApiInfo {

	private String apiKey;

	private String apiSecret;

	public TrelloApiInfo(String apiKey, String apiSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public static TrelloApiInfo loadFromProperties(Properties props) {
		return new TrelloApiInfo(props.getProperty("key"), 
			props.getProperty("secret"));
	}

}
