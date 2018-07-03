package com.github.dieogoliber.openproject.trelloimporter.web.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.dieogoliber.openproject.trelloimporter.model.Account;
import com.github.dieogoliber.openproject.trelloimporter.repository.AccountRepository;

@Component
@Scope(value = "request")
public class LoginSession {
	
	private AccountRepository accountRepo;
	
	private String token;
	
	@Autowired
	private LoginSession(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	public Optional<Account> getCurrentAccount() {
		return accountRepo.findByTrelloToken(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
