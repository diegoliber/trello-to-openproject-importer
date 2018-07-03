package com.github.dieogoliber.openproject.trelloimporter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ConditionRegistry {

	private List<ConditionMixin> conditions = new ArrayList<>();
	
	public List<ConditionMixin> getConditions() {
		
		return conditions;
	}
	
	public void addCondition(ConditionMixin condition) {
		conditions.add(condition);
	}

}
