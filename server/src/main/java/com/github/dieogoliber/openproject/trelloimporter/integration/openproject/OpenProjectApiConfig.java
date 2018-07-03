package com.github.dieogoliber.openproject.trelloimporter.integration.openproject;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenProjectApiConfig {

	@Bean
	@Scope("singleton")
	public OpenProjectApiInfo produceApiInfo(Environment env) {
		return new OpenProjectApiInfo(env.getProperty("openproject.origin"), env.getProperty("openproject.apiRoot"));
	}
	
	@Bean(name = "openProjectRestTemplate")
	public RestTemplate produceRestTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(5000).setReadTimeout(5000).build();
	}
	
}
