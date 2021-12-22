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

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "cocoapp", name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@TypeDef(name = "pgsql_role_type", typeClass = PostgreSQLEnumType.class)
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
	@Type(type = "pgsql_role_type")
	@Column(name = "role", columnDefinition = "role_type", nullable = false)
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
	
	@Column(name = "enabled", nullable = false)
	private Boolean enabled;
	
	@Column(name = "locked", nullable = false)
	private Boolean locked; 
}