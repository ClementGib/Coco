package com.xcg.coco.core.tutorial;

import java.util.Set;

import com.xcg.coco.core.category.CategoryEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tutorial {

	int id;
	
	String title;

	Set<CategoryEntity> categories;

	String author;
	
	String description;

	String imageName;

	int likeCount;
	
}
