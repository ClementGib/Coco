package com.xcg.coco.core.temp;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xcg.coco.core.category.CategoryEntity;
import com.xcg.coco.core.category.CategoryRepository;
import com.xcg.coco.core.tutorial.TutorialEntity;
import com.xcg.coco.core.tutorial.TutorialRepository;

@Startup
@Singleton
public class CoreTesting {

	@Inject
	CategoryRepository categoryRepository;
	
	@Inject
	TutorialRepository tutorialRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {
		
		CategoryEntity category = new CategoryEntity();
		category.setName("Gaming");
		category.setDescription("Very fun games");
		categoryRepository.add(category);
		
		
		
		TutorialEntity tuto = new TutorialEntity();
		tuto.setAuthor("Clement");
		tuto.getCategories().add(category);
		tuto.setDescription("Okkk");
		tuto.setImageName("img.png");
		tuto.setLikeCount(0);
		tuto.setTitle("Titre");
		tutorialRepository.add(tuto);
	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		LOGGER.info("CoreTesting is running!");
		CategoryEntity category = categoryRepository.findById("Gaming").get();
		LOGGER.info(category.getDescription());
//		LOGGER.info(category.getTutorials().size());
		String author = category.getTutorials().iterator().next().getAuthor();
		LOGGER.info("Author : " + author);		
		
		TutorialEntity tuto = tutorialRepository.findById(1).get();
		LOGGER.info(tuto.getAuthor());
		LOGGER.info(tuto.getDescription());
		String name = tuto.getCategories().iterator().next().getName();
		LOGGER.info("Name : " + name);		
		
	}
}
