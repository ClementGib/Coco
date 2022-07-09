package com.cdx.coco.core.user;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.cdx.coco.domain.user.Role;
import com.cdx.coco.core.comment.CommentEntity;
import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity
@Table(schema = "cocoapp", name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@TypeDef(name = "jsonb", typeClass = JsonType.class)
public class UserEntity {

	@Id
	@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq_gen")
	@SequenceGenerator(name = "users_user_id_seq_gen", sequenceName = "users_user_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 25, nullable = false)
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
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("page_id")
	private List<CommentEntity> comments = new ArrayList<>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
}