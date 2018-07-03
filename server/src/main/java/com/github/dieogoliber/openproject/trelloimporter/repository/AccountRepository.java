package com.github.dieogoliber.openproject.trelloimporter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.dieogoliber.openproject.trelloimporter.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{

	@Query("select a from Account a where a.trelloToken = ?1")
	public Optional<Account> findByTrelloToken(String token);
	
}
