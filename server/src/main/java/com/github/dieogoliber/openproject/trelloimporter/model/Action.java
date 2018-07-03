package com.github.dieogoliber.openproject.trelloimporter.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Action {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String operationName;
	
	@Embedded
	private Variable variable;
	
	@ManyToOne
	private Transformation transformation;
	
	public Action() {}

	public Action(Integer id, String operationName, Variable variable) {
		super();
		this.id = id;
		this.operationName = operationName;
		this.variable = variable;
	}
	
	public Action(String operationName, Variable variable) {
		this(null, operationName, variable);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
