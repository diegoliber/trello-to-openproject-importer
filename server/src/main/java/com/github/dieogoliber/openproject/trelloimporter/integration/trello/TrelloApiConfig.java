package com.github.dieogoliber.openproject.trelloimporter.integration.trello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TrelloApiConfig {
	
	@Bean
	@Scope("singleton")
	public TrelloApiInfo loadTrelloApiConfig(Environment env) {
		TrelloApiInfo config = null;
		
		String key = env.getProperty("trello.key");
		String secret = env.getProperty("trello.secret");

		config = new TrelloApiInfo(key,secret);
		
		return config;
		
	}

	@Bean(name = "trelloRestTemplate")
	public RestTemplate createRestTemplate(Environment env) {
		RestTemplate template = new RestTemplateBuilder()
			.setConnectTimeout(5000).setReadTimeout(3000).build();
		
		return template;
	}
	
}
