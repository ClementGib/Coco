package com.xcg.coco.core.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class User {
	
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
		int result;
		result = 31 * result + username.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + history.hashCode();
		result = 31 * result + birthday.hashCode();
		result = 31 * result + creationDate.hashCode();
		result = 31 * result + admin.hashCode();
		return result;
}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		User other = (User) obj;
		return Objects.equals(username, other.username)
				&& Objects.equals(admin, other.admin)
				&& Objects.equals(birthday, other.birthday)
				&& Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(email, other.email)
				&& Objects.equals(history, other.history)
				&& Objects.equals(password, other.password);
	}
	
	
}
