package com.xcg.coco.core.page;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author xzem
 *
 */
public class PageEntity {

	@Id
	@Column(name = "page_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pages_page_id_seq_gen")
	@SequenceGenerator(name = "pages_page_id_seq_gen", sequenceName = "pages_page_id_seq", allocationSize = 1, initialValue = 1)
	Integer id;

	@Column(name = "title", nullable = false)
	String title;
	
	@Column(name = "position", nullable = false)
	Integer position;
	
	@Column(name = "tutorial_id", nullable = false)
	Integer tutorialId;
	
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
