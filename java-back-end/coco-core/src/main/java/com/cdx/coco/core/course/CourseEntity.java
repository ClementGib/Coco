package com.cdx.coco.core.course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cdx.coco.core.category.CategoryEntity;
import com.cdx.coco.core.page.PageEntity;


@Entity
@Table(schema = "cocoapp", name = "courses", uniqueConstraints = @UniqueConstraint(columnNames = "course_id")) 
public class CourseEntity {

	@Id
	@Column(name = "course_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_course_id_seq_gen")
	@SequenceGenerator(name = "courses_course_id_seq_gen", sequenceName = "courses_course_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "image_name", nullable = false)
	private String imageName;

	@Column(name = "like_count", nullable = false)
	private Integer likeCount;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PageEntity> pages = new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "courses_categories",
	           joinColumns = @JoinColumn(name = "course_id"),
	           inverseJoinColumns = @JoinColumn(name = "category_name"))
	private Set<CategoryEntity> categories = new HashSet<CategoryEntity>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public List<PageEntity> getPages() {
		return pages;
	}

	public void setPages(List<PageEntity> pages) {
		this.pages = pages;
	}

	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
	}
}
