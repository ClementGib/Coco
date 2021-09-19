package com.xcg.coco.core.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class UserDTO {

	private String username;

	//TODO Hash password handler
	private String password;

	private String email;

	private Map<String, String> history;

	private LocalDate birthday;

	private Instant creationDate;

	private boolean admin;

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (username == null ? 0 : username.hashCode());
		hash = 31 * hash + (password == null ? 0 : password.hashCode());
		hash = 31 * hash + (email == null ? 0 : email.hashCode());
		hash = 31 * hash + (history == null ? 0 : history.hashCode());
		hash = 31 * hash + (birthday == null ? 0 : birthday.hashCode());
		hash = 31 * hash + (creationDate == null ? 0 : creationDate.hashCode());
		hash = 31 * hash + (admin ? 0 : 1);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		UserDTO other = (UserDTO) obj;
		return Objects.equals(username, other.username) 
				&& Objects.equals(admin, other.admin)
				&& Objects.equals(birthday, other.birthday) 
				&& Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(email, other.email) 
				&& Objects.equals(history, other.history)
				&& Objects.equals(password, other.password);
	}

}
