package com.github.dieogoliber.openproject.trelloimporter.web.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dieogoliber.openproject.trelloimporter.web.filter.LoginFilter;

@Configuration
public class FilterConfig implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Bean
	public FilterRegistrationBean<LoginFilter> filterRegistrationBean() {
		FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new LoginFilter(applicationContext));
		registration.addUrlPatterns("/*");
		registration.setName("accountFilter");
		registration.setOrder(1);
		return registration;
	}
	
}
