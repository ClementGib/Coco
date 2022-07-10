package com.cdx.coco.application.post;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cdx.coco.application.page.PageEntity;

/**
 * @author Clément Gibert
 *
 */
@Entity
@Table(schema = "cocoapp", name = "posts", uniqueConstraints = @UniqueConstraint(columnNames = "post_id")) 
public class PostEntity {

	@Id
	@Column(name = "post_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_post_id_seq_gen")
	@SequenceGenerator(name = "posts_post_id_seq_gen", sequenceName = "posts_post_id_seq", allocationSize = 1, initialValue = 1)
	Integer id;
	
	@Column(name = "position", nullable = false)
	Integer position;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "page_id", nullable = false) 
    private PageEntity page;
	
	@Column(name = "title", nullable = false)
	String title;
	
	@Column(name = "content", nullable = false)
	String content;
	
	@Column(name = "update_date", nullable = false)
	Instant updateDate;
	
	@Column(name = "creation_date", nullable = false)
	Instant creationDate;

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

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
}
