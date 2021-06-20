package com.clement.gibert.coco.api.tutorial;

public class Tutorial {
	
	private String title;
	
	private Type type;
	
	private String author;
	
	private String description;
	
	private String imageName;
	
	private int like;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	

}
