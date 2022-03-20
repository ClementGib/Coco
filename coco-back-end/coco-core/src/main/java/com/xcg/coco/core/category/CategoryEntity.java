package com.xcg.coco.core.category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xcg.coco.core.tutorial.TutorialEntity;

@Entity
@Table(schema = "cocoapp", name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CategoryEntity implements Serializable {
	
	/**
	 * V0.0.1
	 */
	private static final long serialVersionUID = -1414356231558819992L;

	@Id
	String name;
	
	@Column(name = "description", nullable = false)
	String description;
	
    @ManyToMany(mappedBy = "categories")
    private Set<TutorialEntity> tutorials = new HashSet<TutorialEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TutorialEntity> getTutorials() {
		return tutorials;
	}

	public void setTutorials(Set<TutorialEntity> tutorials) {
		this.tutorials = tutorials;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}