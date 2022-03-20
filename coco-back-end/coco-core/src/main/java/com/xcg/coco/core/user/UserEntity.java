package com.xcg.coco.core.user;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity
@Table(schema = "cocoapp", name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@TypeDef(name = "jsonb", typeClass = JsonType.class)
public class UserEntity implements Serializable {

	/**
	 * V0.0.1
	 */
	private static final long serialVersionUID = 6644713357542923727L;

	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	@Column(name = "email", nullable = false)
	private String email;

	@Type(type = "jsonb")
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
}