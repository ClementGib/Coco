package com.xcg.coco.core.temp;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class CoreTesting {
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreTesting.class);

	@PostConstruct
	public void init() {
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.error("ERROR");
	}

	@Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 second timer")
	public void tester() {
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.error("ERROR");
	}
}
