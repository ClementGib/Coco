package com.xcg.coco.core.comment;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(schema = "cocoapp", name = "comments", uniqueConstraints = @UniqueConstraint(columnNames = "comment_id"))
public class CommentEntity implements Serializable {

	/**
	 * V0.0.1
	 */
	private static final long serialVersionUID = -1125312721510639222L;

	@Id
	@Column(name = "comment_id", nullable = false)
	private long commentId;

	@Column(name = "tutorial_id", nullable = false)
	private long tutorialId;

	@Column(name = "user_username", nullable = false)
	private String userUsername;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "creation_date", nullable = false)
	private Instant creationDate;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(long tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
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
}
