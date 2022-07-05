-- CREATE USERS --
CREATE USER cocoadm WITH PASSWORD 'postgres';
CREATE USER cocoweb WITH PASSWORD 'postgres';

-- CREATE DATABASE --
CREATE DATABASE cocotuto;

-- SELECT DATABASE --
\c cocotuto

-- CREATE EXTENSION --
CREATE EXTENSION pgcrypto;

-- CREATE SCHEMA --
CREATE SCHEMA cocoapp;

-- GRANT USER --
GRANT ALL ON DATABASE cocotuto TO cocoadm;
GRANT ALL ON SCHEMA cocoapp TO cocoadm;


-- SET DEFAULT SCHEMA --
SET search_path TO cocoapp;

-- CREATE TABLES --

-- CREATE users TABLE --
	CREATE TABLE cocoapp.users
(
	user_id SERIAL UNIQUE NOT NULL,
	username varchar(255) UNIQUE NOT NULL,
	password text NOT NULL,
	role varchar(25) NOT NULL,
	email varchar(255) UNIQUE NOT NULL,
	history jsonb NOT NULL,
	birthday DATE NOT NULL,
	creation_date timestamp NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY (user_id)
	);

-- CREATE categories TABLE --
	CREATE TABLE cocoapp.categories
(
	name varchar(255) UNIQUE NOT NULL UNIQUE,
	description text NOT NULL,
	CONSTRAINT pk_categories PRIMARY KEY (name)
	);
	
-- CREATE courses TABLE --
	CREATE TABLE cocoapp.courses
(
	course_id SERIAL UNIQUE NOT NULL,
	title varchar(255) UNIQUE NOT NULL,
	author varchar(255) NOT NULL,
	description text NOT NULL,
	image_name varchar(255),
	like_count integer NOT NULL,
	CONSTRAINT pk_courses PRIMARY KEY (course_id)
	);

	-- CREATE courses_categories TABLE --
	CREATE TABLE cocoapp.courses_categories
(
	course_id integer UNIQUE NOT NULL,
	category_name varchar(255) NOT NULL,
	PRIMARY KEY (course_id, category_name),
	CONSTRAINT fk_course_id FOREIGN KEY(course_id) REFERENCES cocoapp.courses(course_id),
	CONSTRAINT fk_category_name FOREIGN KEY(category_name) REFERENCES cocoapp.categories(name)
	);

-- CREATE pages TABLE --
	CREATE TABLE cocoapp.pages
	(
	page_id SERIAL UNIQUE NOT NULL, 
	course_id integer NOT NULL,
	position integer NOT NULL,
	title text NOT NULL,
	creation_date timestamp NOT NULL,
	update_date timestamp NOT NULL,
	CONSTRAINT pk_pages PRIMARY KEY (page_id),
	CONSTRAINT fk_pages_courses FOREIGN KEY(course_id) REFERENCES cocoapp.courses(course_id)
	);
	
-- CREATE posts TABLE --
	CREATE TABLE cocoapp.posts
	(
	post_id SERIAL UNIQUE NOT NULL,
	page_id integer NOT NULL,
	position integer NOT NULL,	
	title text NOT NULL,
	content text NOT NULL,
	creation_date timestamp NOT NULL,
	update_date timestamp NOT NULL,
	CONSTRAINT pk_posts PRIMARY KEY (post_id),
	CONSTRAINT fk_posts_pages FOREIGN KEY(page_id) REFERENCES cocoapp.pages(page_id)
	);

	-- CREATE comments TABLE --
	CREATE TABLE cocoapp.comments
(
	comment_id SERIAL UNIQUE NOT NULL,
	page_id integer NOT NULL,
	username varchar(255) NOT NULL,
	content text NOT NULL,
	creation_date timestamp NOT NULL,
	modified boolean,
	PRIMARY KEY (comment_id),
	CONSTRAINT fk_comments_users FOREIGN KEY(username) REFERENCES cocoapp.users(username),
	CONSTRAINT fk_page_id FOREIGN KEY(page_id) REFERENCES cocoapp.pages(page_id)
	);
	
-- CREATE dictionnaries TABLE --
	CREATE TABLE cocoapp.dictionnaries
	(
	word varchar(255) UNIQUE NOT NULL UNIQUE,
	description text NOT NULL,
	used integer NOT NULL,
	CONSTRAINT pk_dictionnaries PRIMARY KEY (word)
	);
	
-- CREATE ids TABLE --
	CREATE TABLE cocoapp.ids
	(
	origin varchar(255) UNIQUE NOT NULL UNIQUE,
	username varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password text NOT NULL,
	description text NOT NULL,
	CONSTRAINT pk_ids PRIMARY KEY (origin)
	);
	
	
-- GRANT cocoadm -- 
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA cocoapp TO cocoadm;	
GRANT SELECT, UPDATE, USAGE ON ALL SEQUENCES IN SCHEMA cocoapp to cocoadm;

-- GRANT cocoweb --
GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE comments TO cocoweb;
GRANT SELECT, UPDATE, USAGE ON "comments_comment_id_seq" TO cocoweb;

GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE courses TO cocoweb;
GRANT SELECT, UPDATE, USAGE ON "courses_course_id_seq" TO cocoweb;

GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE pages TO cocoweb;
GRANT SELECT, UPDATE, USAGE ON "pages_page_id_seq" TO cocoweb;

GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE posts TO cocoweb;
GRANT SELECT, UPDATE, USAGE ON "posts_post_id_seq" TO cocoweb;

GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE categories TO cocoweb;
GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE dictionnaries TO cocoweb;
GRANT SELECT, UPDATE, INSERT , DELETE ON TABLE courses_categories TO cocoweb;
