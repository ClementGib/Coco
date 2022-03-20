package com.xcg.coco.core.page;

import java.time.Instant;

/**
 * @author xzem
 *
 */
public class Page {

	Integer id;
	
	String title;
	
	Integer position;
	
	Integer tutorialId;
	
	Instant updateDate;
	
	Instant creationDate;

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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(Integer tutorialId) {
		this.tutorialId = tutorialId;
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
