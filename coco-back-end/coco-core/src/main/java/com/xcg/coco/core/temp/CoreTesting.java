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
		
		CategoryEntity category = new CategoryEntity();
		category.setName("Gaming");
		category.setDescription("Very fun games");
		categoryRepository.add(category);
		
		UserEntity user = new UserEntity();
		user.setBirthday(LocalDate.of(2020, 1, 8));
		user.setEmail("test@gmail.com");
		user.setHistory("{}");
		user.setCreationDate(Instant.now());
		user.setPassword("abc");
		user.setRole(Role.GUEST);
		user.setUsername("Clement");
		userRepository.add(user);
		
		CommentEntity comment = new CommentEntity();
		comment.setContent("Im not happy");
		comment.setUsername("Clement");
		comment.setCreationDate(Instant.now());
		
		TutorialEntity tuto = new TutorialEntity();
		PageEntity page = new PageEntity();
		comment.setPage(page);
		PostEntity post = new PostEntity();
		post.setTitle("Premier post");
		post.setContent("Dans cette première partie je vais parler des rollerrrr");
		post.setPosition(1);
		post.setCreationDate(Instant.now());
		post.setUpdateDate(Instant.now());
		post.setPage(page);
		
		page.setTitle("Premiere page");
		page.getComments().add(comment);
		page.setCreationDate(Instant.now());
		page.setPosition(1);
		page.setUpdateDate(Instant.now());
		page.setTutorial(tuto);
		page.getPosts().add(post);
	
		tuto.setAuthor("Clement");
		tuto.getCategories().add(category);
		tuto.setDescription("Okkk");
		tuto.setImageName("img.png");
		tuto.setLikeCount(0);
		tuto.setTitle("Titre");
		tuto.getPages().add(page);
		tutorialRepository.update(tuto);
		
	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		
		LOGGER.info("CoreTesting is running!");
		Integer id = userRepository.findAll().get(0).getId();
		LOGGER.info("User ID: " + id);

//		CategoryEntity category = categoryRepository.findById("Gaming").get();
//		LOGGER.info(category.getDescription());
//		LOGGER.info("{}", category.getTutorials().size());
//		String author = category.getTutorials().iterator().next().getAuthor();
//		LOGGER.info("Author : " + author);		
//		
//		TutorialEntity tuto = tutorialRepository.findById(1).get();
//		LOGGER.info(tuto.getAuthor());
//		LOGGER.info(tuto.getDescription());
//		String name = tuto.getCategories().iterator().next().getName();
//		LOGGER.info("Name : " + name);		
	}
}
