package com.github.dieogoliber.openproject.trelloimporter.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variable {
	
	@Column
	@JsonProperty
	private String objectType;
	
	@Column
	@JsonProperty
	private String objectId;
	
	@Column
	@JsonProperty
	private String objectPropertyValue;
	
	public Variable() {}

	public Variable(String objectType, String objectId, String value) {
		super();
		this.objectType = objectType;
		this.objectId = objectId;
		this.objectPropertyValue = value;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String id) {
		this.objectId = id;
	}

	public String getObjectPropertyValue() {
		return objectPropertyValue;
	}

	public void setObjectPropertyValue(String objectPropertyValue) {
		this.objectPropertyValue = objectPropertyValue;
	}

}
