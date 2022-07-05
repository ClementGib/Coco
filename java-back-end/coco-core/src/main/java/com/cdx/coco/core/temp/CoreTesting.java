package com.cdx.coco.core.temp;

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

import com.cdx.coco.api.user.Role;
import com.cdx.coco.core.category.CategoryRepository;
import com.cdx.coco.core.course.CourseRepository;
import com.cdx.coco.core.page.PageRepository;
import com.cdx.coco.core.user.UserEntity;
import com.cdx.coco.core.user.UserRepository;


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
		List<UserEntity> users = userRepository.findAll();
		if(users.isEmpty()) {
			UserEntity user = new UserEntity();
			user.setBirthday(LocalDate.now());
			user.setUsername("clem");
			user.setEmail("test.fr");
			user.setPassword("MDP");
			user.setCreationDate(Instant.now());
			user.setRole(Role.GUEST);
			user.setHistory("{}");
			userRepository.add(user);
		} else {
			LOGGER.info("User ID: " + users.get(0).getId());
		}
	}
}
