package com.cdx.coco.application.page;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cdx.coco.application.comment.CommentEntity;
import com.cdx.coco.application.course.CourseEntity;
import com.cdx.coco.application.post.PostEntity;

/**
 * @author Clément Gibert
 *
 */
@Entity
@Table(schema = "cocoapp", name = "pages", uniqueConstraints = @UniqueConstraint(columnNames = "page_id")) 
public class PageEntity {

	@Id
	@Column(name = "page_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_page_id_seq_gen")
	@SequenceGenerator(name = "pages_page_id_seq_gen", sequenceName = "pages_page_id_seq", allocationSize = 1, initialValue = 1)
	Integer id;

	@Column(name = "position", nullable = false)
	Integer position;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false) 
    private CourseEntity course;
	
	@Column(name = "title", nullable = false)
	String title;
	
	@Column(name = "update_date", nullable = false)
	Instant updateDate;
	
	@Column(name = "creation_date", nullable = false)
	Instant creationDate;
	
	@OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("creation_date")
	private List<PostEntity> posts = new ArrayList<>();
	
	@OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("creation_date")
	private List<CommentEntity> comments = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Instant updateDate) {
		this.updateDate = updateDate;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
}
