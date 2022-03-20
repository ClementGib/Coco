package com.xcg.coco.core.tutorial;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xcg.coco.core.category.CategoryEntity;



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
	   
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tutorials_categories",
	           joinColumns = @JoinColumn(name = "tutorial_id"),
	           inverseJoinColumns = @JoinColumn(name = "category_name"))
	private Set<CategoryEntity> categories = new HashSet<CategoryEntity>();
	
	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "image_name", nullable = false)
	private String imageName;

	@Column(name = "like_count", nullable = false)
	private int likeCount;

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//	List<Post> posts;

	
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

	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
