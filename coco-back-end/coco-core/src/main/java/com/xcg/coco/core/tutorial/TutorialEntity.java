package com.xcg.coco.core.tutorial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(schema = "cocoapp", name = "tutorials", uniqueConstraints = { 
//		@UniqueConstraint(columnNames = "tutorial_id"),
//		@UniqueConstraint(columnNames = "category_name") })
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
	Integer id;

	@Column(name = "title", nullable = false)
	String title;

//	@ManyToMany
//	@JoinColumn(name = "category_name", nullable = false)
//	Set<CategoryEntity> categories;

	@Column(name = "author", nullable = false)
	String author;

	@Column(name = "description", nullable = false)
	String description;

	@Column(name = "image_name", nullable = false)
	String imageName;

	@Column(name = "like_count", nullable = false)
	int likeCount;

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//	List<Post> posts;

}
