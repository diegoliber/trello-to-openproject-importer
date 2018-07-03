package com.github.dieogoliber.openproject.trelloimporter.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Board;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Card;
import com.github.dieogoliber.openproject.trelloimporter.model.Variable;

public interface ConditionMixin {

	@JsonProperty("operationName")
	String getOperationName();
	
	List<Variable> getAvailableParameters(Board board, Card card);
	
	boolean verify(Board board, Card card, Variable value);
	
}
