package com.cdx.coco.application.temp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdx.coco.domain.user.Role;
import com.cdx.coco.application.category.CategoryRepository;
import com.cdx.coco.application.course.CourseRepository;
import com.cdx.coco.application.page.PageRepository;
import com.cdx.coco.application.user.UserEntity;
import com.cdx.coco.application.user.UserRepository;


@Startup
@Singleton
public class CoreTesting {

	@Inject
	CategoryRepository categoryRepository;
	
	@Inject
	CourseRepository courseRepository;
	
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
//		List<UserEntity> users = userRepository.findAll();
//		if(users.isEmpty()) {
//			UserEntity user = new UserEntity();
//			user.setBirthday(LocalDate.now());
//			user.setUsername("clem");
//			user.setEmail("test.fr");
//			user.setPassword("MDP");
//			user.setCreationDate(Instant.now());
//			user.setRole(Role.GUEST);
//			user.setHistory("{}");
//			userRepository.add(user);
//		} else {
//			LOGGER.info("User ID: " + users.get(0).getId());
//		}
	}
}
