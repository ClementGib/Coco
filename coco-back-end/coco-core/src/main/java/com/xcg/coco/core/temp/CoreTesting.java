package com.xcg.coco.core.temp;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xcg.coco.core.category.CategoryEntity;
import com.xcg.coco.core.category.CategoryRepository;



@Startup
@Singleton
public class CoreTesting {
	
	@Inject
	CategoryRepository categoryRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {
		try {
			CategoryEntity firstEntity = new CategoryEntity();
			firstEntity.setName("java");
			firstEntity.setDescription("test");
			
			categoryRepository.add(firstEntity);
			LOGGER.info(firstEntity.getName() + " pesisted");
			Optional<CategoryEntity> category = categoryRepository.findById("Java");
			
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
