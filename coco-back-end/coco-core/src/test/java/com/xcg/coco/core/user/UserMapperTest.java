package com.xcg.coco.core.user;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

	@Before
	public void init() {

	}

	@Test
	public void testOne() {
		UserEntity user = new UserEntity();
		user.getBirthday();
	}

}
