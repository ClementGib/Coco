package com.xcg.coco.core.temp;

import java.time.Instant;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xcg.coco.core.category.CategoryEntity;
import com.xcg.coco.core.category.CategoryRepository;
import com.xcg.coco.core.comment.CommentEntity;
import com.xcg.coco.core.page.PageEntity;
import com.xcg.coco.core.page.PageRepository;
import com.xcg.coco.core.post.PostEntity;
import com.xcg.coco.core.tutorial.TutorialEntity;
import com.xcg.coco.core.tutorial.TutorialRepository;
import com.xcg.coco.core.user.Role;
import com.xcg.coco.core.user.UserEntity;
import com.xcg.coco.core.user.UserRepository;

@Startup
@Singleton
public class CoreTesting {

	@Inject
	CategoryRepository categoryRepository;
	
	@Inject
	TutorialRepository tutorialRepository;
	
	@Inject
	UserRepository userRepository;
	
	@Inject
	PageRepository pageRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {
		
	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		
		LOGGER.info("CoreTesting is running!");
		Integer id = userRepository.findAll().get(0).getId();
		LOGGER.info("User ID: " + id);
	}
}
