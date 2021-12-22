package com.xcg.coco.core.temp;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xcg.coco.core.category.CategoryRepository;



@Startup
@Singleton
public class CoreTesting {
	
	@Inject
	CategoryRepository categoryRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {

	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		
		LOGGER.info("CoreTesting is running!");

	}
}
