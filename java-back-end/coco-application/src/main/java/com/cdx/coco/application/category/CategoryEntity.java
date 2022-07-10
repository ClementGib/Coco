package com.cdx.coco.application.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cdx.coco.application.course.CourseEntity;

@Entity
@Table(schema = "cocoapp", name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CategoryEntity {

	@Id
	String name;
	
	@Column(name = "description", nullable = false)
	String description;
	
    @ManyToMany(mappedBy = "categories")
    private Set<CourseEntity> courses = new HashSet<CourseEntity>();

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

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}
}