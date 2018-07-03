package com.github.dieogoliber.openproject.trelloimporter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conversion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String sourceId;
	
	@Column
	private String targetId;

	@OneToMany
	private List<Transformation> transformations;
	
	public Conversion() {}

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

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public List<Transformation> getTransformations() {
		return transformations;
	}

	public void setTransformations(List<Transformation> transformations) {
		this.transformations = transformations;
	}
	
}
