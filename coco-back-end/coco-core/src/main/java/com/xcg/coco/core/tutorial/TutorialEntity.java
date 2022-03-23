package com.xcg.coco.core.tutorial;

import java.io.Serializable;
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

import com.xcg.coco.core.category.CategoryEntity;
import com.xcg.coco.core.page.PageEntity;


@Entity
@Table(schema = "cocoapp", name = "tutorials", uniqueConstraints = @UniqueConstraint(columnNames = "tutorial_id")) 
public class TutorialEntity implements Serializable {

	/**
	 * V0.0.1
	 */
	private static final long serialVersionUID = -5204051786157374314L;

	@Id
	@Column(name = "tutorial_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorials_tutorial_id_seq_gen")
	@SequenceGenerator(name = "tutorials_tutorial_id_seq_gen", sequenceName = "tutorials_tutorial_id_seq", allocationSize = 1, initialValue = 1)
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
	private int likeCount;

	@OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PageEntity> pages = new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tutorials_categories",
	           joinColumns = @JoinColumn(name = "tutorial_id"),
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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
