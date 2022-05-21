package com.cdx.coco.core.comment;

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

import com.cdx.coco.core.page.PageEntity;

@Entity
@Table(schema = "cocoapp", name = "comments", uniqueConstraints = @UniqueConstraint(columnNames = "comment_id"))
public class CommentEntity {

	@Id
	@Column(name = "comment_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_comment_id_seq_gen")
	@SequenceGenerator(name = "comments_comment_id_seq_gen", sequenceName = "comments_comment_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "page_id", nullable = false) 
    private PageEntity page;

	@JoinColumn(name = "username", nullable = false) 
	private String username;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "creation_date", nullable = false)
	private Instant creationDate;
	
	@Column(name = "modified", nullable = false)
	private boolean modified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}
}
