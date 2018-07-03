package com.github.dieogoliber.openproject.trelloimporter.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.Project;
import com.github.dieogoliber.openproject.trelloimporter.integration.openproject.model.WorkPackage;
import com.github.dieogoliber.openproject.trelloimporter.model.Variable;

public interface ActionMixin {
	
	@JsonProperty
	String getOperationName();
	
	List<Variable> getAvailableValues();
	
	boolean perform(Project project, WorkPackage wp, String...values);

}
