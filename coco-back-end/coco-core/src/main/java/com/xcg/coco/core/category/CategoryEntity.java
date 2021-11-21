package com.xcg.coco.core.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}