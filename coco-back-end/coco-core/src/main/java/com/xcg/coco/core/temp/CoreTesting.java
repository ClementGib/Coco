package com.xcg.coco.core.temp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xcg.coco.core.user.Role;
import com.xcg.coco.core.user.UserEntity;



@Startup
@Singleton
public class CoreTesting {
	
	@Inject
	CategoryDao categoryDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {
		try {
			UserEntity firstEntity = new UserEntity();
			firstEntity.setUsername("Clement");
			firstEntity.setPassword("azerty");
			firstEntity.setRole(Role.ADMIN);
			firstEntity.setEmail("test@gmail.com");
			firstEntity.setHistory("{}");
			firstEntity.setBirthday(LocalDate.of(2000, 10, 10));
			firstEntity.setCreationDate(Instant.now());
			
			categoryDAO.add(firstEntity);
			LOGGER.info(firstEntity.getName() + " pesisted");
			Optional<UserEntity> category = categoryDAO.findById("Java");
			
			if(category.isPresent()) {
				LOGGER.info("found :" + category.get());
				LOGGER.info("found :" + category.get().getDescription());
			}
			
		} catch (Exception Exception) {
			LOGGER.error("ERROR:", Exception);
		}

	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		
		LOGGER.info("CoreTesting is running!");

	}
}
