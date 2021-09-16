package com.xcg.coco.core.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "admin", nullable = false)
	private boolean admin;

	@Column(name = "email", nullable = false)
	private String email;

	@Type(type = "json")
	@Column(name = "history", columnDefinition = "jsonb")
	private String history;

	@Column(name = "birthday", nullable = false)
	private LocalDate birthday;

	@Column(name = "creation_date", nullable = false)
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
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

	//Ne pas surcharger ?
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		UserEntity other = (UserEntity) obj;
		return Objects.equals(username, other.username) 
				&& Objects.equals(admin, other.admin)
				&& Objects.equals(birthday, other.birthday) 
				&& Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(email, other.email) 
				&& Objects.equals(history, other.history)
				&& Objects.equals(password, other.password);
	}

}
