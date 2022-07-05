package com.cdx.coco.api.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

public class User {
	
	private String username;

	private String password;

	private Role role;
	
	private String email;
	
	private Map<String, String> history;
	
	private LocalDate birthday;
	
	private Instant creationDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> getHistory() {
		return history;
	}

	public void setHistory(Map<String, String> history) {
		this.history = history;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
}
