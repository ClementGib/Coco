package com.cdx.coco.core.user;

import org.junit.Before;
import org.junit.Test;

import com.cdx.coco.core.user.UserEntity;

public class UserMapperTest {

	@Before
	public void init() {

	}

	@Test
	public void testOne() {
		UserEntity user = new UserEntity();
		user.getBirthday();
	}

}
