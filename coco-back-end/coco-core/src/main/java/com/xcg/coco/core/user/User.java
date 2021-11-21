package com.xcg.coco.core.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private String username;

	private String password;

	private Role role;
	
	private String email;
	
	private Map<String, String> history;
	
	private LocalDate birthday;
	
	private Instant creationDate;
}
