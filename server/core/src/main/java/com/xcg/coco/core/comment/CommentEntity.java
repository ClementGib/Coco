package com.xcg.coco.core.comment;

import java.time.Instant;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(commentId, tutorialId, userId, content, creationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		CommentEntity other = (CommentEntity) obj;
		return Objects.equals(commentId, other.commentId) 
				&& Objects.equals(tutorialId, other.tutorialId)
				&& Objects.equals(userId, other.userId) 
				&& Objects.equals(content, other.content)
				&& Objects.equals(creationDate, other.creationDate);
	}

}
