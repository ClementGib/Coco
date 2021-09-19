package com.xcg.coco.core.comment;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {

	@Id
	@Column(name = "comment_id", nullable = false)
	private long commentId;

	@Column(name = "tutorial_id", nullable = false)
	private long tutorialId;

	@Column(name = "user_id", nullable = false)
	private long userId;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
