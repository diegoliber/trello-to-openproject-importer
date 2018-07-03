package com.github.dieogoliber.openproject.trelloimporter.web.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.OpenProjectClient;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.TrelloApiInfo;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.TrelloClient;
import com.github.dieogoliber.openproject.trelloimporter.model.Account;
import com.github.dieogoliber.openproject.trelloimporter.repository.AccountRepository;
import com.github.dieogoliber.openproject.trelloimporter.web.model.LoginSession;

@Controller
@Scope("request")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private LoginSession loginSession;

	@Autowired
	private TrelloApiInfo trelloApiInfo;
	
	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TrelloClient trelloClient;
	
	@Autowired
	private OpenProjectClient openProjectClient;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Account> getAccount() {
		
		
		Optional<Account> opt = loginSession.getCurrentAccount();
		if (opt.isPresent()) {
			Account account = opt.get();
			LOGGER.info("Current account, with username {0} and token {1}", 
				account.getUsername(), account.getTrelloToken());
			return ResponseEntity.ok(account);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
    public ResponseEntity<?> getLoginUrlTemplate(@RequestParam("callbackUrl") String callbackUrl) {
    	
    	StringBuilder builder = new StringBuilder();
    	builder.append("https://trello.com/1/authorize?expiration=1day&name=MyPersonalToken&scope=read&response_type=token");
    	
    	builder.append(String.format("&key=%s", trelloApiInfo.getApiKey()));
    	builder.append(String.format("&callback_method=fragment&return_url=%s", callbackUrl));
    	
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", builder.toString()).build();
    }

	@Transactional
	@RequestMapping(value = "/account/trello/token", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> storeTrelloToken(@RequestBody String token) {
		
		
		final Account user = trelloClient.getCurrentUser(token);
		
		Optional<Account> storedUser = this.accountRepo.findById(user.getUsername());
		if(storedUser.isPresent()) {
			storedUser.ifPresent(a -> {
				a.setTrelloToken(token);
				a.setFullName(user.getFullName());
				a.setTrelloId(user.getTrelloId());
				this.accountRepo.save(a);
			});
			
		} else {
			this.accountRepo.save(user);
		}
			

		return ResponseEntity.ok().build();
	}

	@Transactional
	@RequestMapping(value = "/account/openproject/token", method = RequestMethod.POST, 
			consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> storeOpenProjectToken(@RequestBody String token) {
		
		Optional<Account> optAccount = loginSession.getCurrentAccount();
		if (optAccount.isPresent() && this.openProjectClient.testOpenProjectApi(token)) {
			
			Account account = optAccount.get();
			account.setOpenProjectToken(token);
			this.accountRepo.save(account);
			return ResponseEntity.ok().build();
			
		} else {
			return ResponseEntity.badRequest().body("User not authenticated or problem retrieving user account.");
		}
	}
	
}
