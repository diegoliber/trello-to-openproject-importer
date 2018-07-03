package com.github.dieogoliber.openproject.trelloimporter.web.controller;

import java.util.List;

import org.apache.tomcat.websocket.Transformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.dieogoliber.openproject.trelloimporter.repository.TransformationRepository;
import com.github.dieogoliber.openproject.trelloimporter.service.ActionMixin;
import com.github.dieogoliber.openproject.trelloimporter.service.ActionRegistry;
import com.github.dieogoliber.openproject.trelloimporter.service.ConditionMixin;
import com.github.dieogoliber.openproject.trelloimporter.service.ConditionRegistry;

public class TransformationController {
	
	private ConditionRegistry conditionRegistry;
	
	private ActionRegistry actionRegistry;
	
	private TransformationRepository transformRepo;
	
	@RequestMapping(value = "/conditions")
	public ResponseEntity<?> getAvailableConditions() {
		List<ConditionMixin> conditions = conditionRegistry.getConditions();
		
		if (!conditions.isEmpty()) {
			return ResponseEntity.ok(conditions);
		}
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(value = "/actions")
	public ResponseEntity<?> getAvailableActions() {
		
		List<ActionMixin> actions = actionRegistry.getActions();
		
		if (!actions.isEmpty()) {
			return ResponseEntity.ok(actions);
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> getTransformations() {
		
		
		
		return null;
	}
	
	public ResponseEntity<?> getTransformationById(String transformation) {
		return null;
	}
	
	public ResponseEntity<?> addTransformation(Transformation transform) {
		return null;
	}
	
	public ResponseEntity<?> updateTransformation(Transformation transform) {
		return null;
	}
	
	public ResponseEntity<?> removeTransformation(String transformationId) {
		return null;
	}
	
}
