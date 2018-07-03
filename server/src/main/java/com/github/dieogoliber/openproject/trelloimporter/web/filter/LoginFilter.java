package com.github.dieogoliber.openproject.trelloimporter.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;

import com.github.dieogoliber.openproject.trelloimporter.web.model.LoginSession;

public class LoginFilter implements Filter {
	
	private ApplicationContext context;
		
	public LoginFilter() {}
	
	public LoginFilter(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }
	
	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String token = httpRequest.getHeader("X-Access-Token");
		if (token != null) {
			LoginSession session = context.getBean(LoginSession.class);
			session.setToken(token);
		}
		
		chain.doFilter(httpRequest, response);
	}

}
