
-- CREATE EXTENSION --
CREATE EXTENSION pgcrypto;

-- CREATE SCHEMA --
CREATE SCHEMA cocoapp;

-- GRANT USER --
GRANT ALL ON DATABASE cocotuto TO cocoadm;
GRANT ALL ON SCHEMA cocoapp TO cocoadm;


-- SET DEFAULT SCHEMA --
SET search_path TO cocoapp;

-- CREATE ENUM --
CREATE TYPE role_type AS ENUM (
    'USER', 
    'ADMIN', 
    'GUEST'
);

-- CREATE TABLES --

-- CREATE users TABLE --
	CREATE TABLE cocoapp.users
(
	username varchar(255) NOT NULL,
	password text NOT NULL,
	role role_type NOT NULL,
	email varchar(255) NOT NULL,
	history jsonb NOT NULL,
	birthday DATE NOT NULL,
	creation_date timestamp NOT NULL,
	PRIMARY KEY (username)
	);
	
-- CREATE comments TABLE --
	CREATE TABLE cocoapp.comments
(
	comment_id BIGSERIAL NOT NULL,
	tutorial_id bigint NOT NULL,
	user_username varchar(255) NOT NULL,
	content text NOT NULL,
	creation_date timestamp NOT NULL,
	PRIMARY KEY (comment_id),
	CONSTRAINT fk_comments_users FOREIGN KEY(user_username) REFERENCES cocoapp.users(username)
	);

-- CREATE categories TABLE --
	CREATE TABLE cocoapp.categories
(
	name text NOT NULL UNIQUE
	);
	
-- CREATE tutorials TABLE --
	CREATE TABLE cocoapp.tutorials
(
	tutorial_id BIGSERIAL NOT NULL,
	title varchar(255) NOT NULL,
	category varchar(255) NOT NULL,
	author varchar(255) NOT NULL,
	description text NOT NULL,
	image_name varchar(255),
	liked integer NOT NULL,
	last bigint references cocoapp.tutorials(tutorial_id),
	next bigint references cocoapp.tutorials(tutorial_id),
	CONSTRAINT pk_tutorials PRIMARY KEY (tutorial_id),
	CONSTRAINT fk_tutorials FOREIGN KEY(category) REFERENCES cocoapp.categories(name)
	);

-- CREATE pages TABLE --
	CREATE TABLE cocoapp.pages
	(
	page_id BIGSERIAL NOT NULL, 
	page_nb integer NOT NULL,
	tutorial bigint NOT NULL,
	title text NOT NULL,
	creation_date timestamp NOT NULL,
	update_date timestamp NOT NULL,
	CONSTRAINT pk_pages PRIMARY KEY (page_id),
	CONSTRAINT fk_pages FOREIGN KEY(tutorial) REFERENCES cocoapp.tutorials(tutorial_id)
	);
	
-- CREATE posts TABLE --
	CREATE TABLE cocoapp.posts
	(
	post_id BIGSERIAL NOT NULL,
	post_nb integer NOT NULL,
	page bigint NOT NULL,
	title text NOT NULL,
	content text NOT NULL,
	creation_date timestamp NOT NULL,
	update_date timestamp NOT NULL,
	CONSTRAINT pk_posts PRIMARY KEY (post_id),
	CONSTRAINT fk_posts FOREIGN KEY(page) REFERENCES cocoapp.pages(page_id)
	);
	
-- CREATE dictionnaries TABLE --
	CREATE TABLE cocoapp.dictionnaries
	(
	word varchar(255) NOT NULL UNIQUE,
	description text NOT NULL,
	used integer NOT NULL,
	CONSTRAINT pk_dictionnaries PRIMARY KEY (word)
	);
	
-- CREATE ids TABLE --
	CREATE TABLE cocoapp.ids
	(
	origin varchar(255) NOT NULL UNIQUE,
	username text NOT NULL,
	email text NOT NULL,
	password text NOT NULL,
	description text NOT NULL,
	CONSTRAINT pk_ids PRIMARY KEY (origin)
	);


-- REMOVE DATABASE --
CREATE DATABASE cocotuto;

-- REMOVE USERS --
CREATE USER cocoadm WITH PASSWORD 'postgres';
CREATE USER cocoweb WITH PASSWORD 'postgres';
