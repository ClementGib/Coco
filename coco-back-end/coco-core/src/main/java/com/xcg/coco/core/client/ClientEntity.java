package com.xcg.coco.core.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "cocoapp", name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = "client_id"))
@TypeDef(name = "jsonb", typeClass = JsonType.class)
public class ClientEntity {

	@Id
	@Column(name = "client_id")
	private int id;

	@Column(name = "client_secret")
	private String secret;
	
	@Column(name = "redirect_uri")
	private String redirectUri;
	
	@Column(name = "scope")
	private String scope;
}
