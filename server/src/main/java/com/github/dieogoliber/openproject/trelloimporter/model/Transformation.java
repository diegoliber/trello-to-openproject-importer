package com.github.dieogoliber.openproject.trelloimporter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String sourceId;
	
	@Column
	private String targetId;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ConditionEvaluation conditionEvaluation;
	
	@OneToMany(mappedBy = "transformation")
	private List<Condition> conditions;
	
	@OneToMany(mappedBy = "transformation")
	private List<Action> actions;
	
	public Transformation() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public ConditionEvaluation getConditionEvaluation() {
		return conditionEvaluation;
	}

	public void setConditionEvaluation(ConditionEvaluation conditionEvaluation) {
		this.conditionEvaluation = conditionEvaluation;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
}
