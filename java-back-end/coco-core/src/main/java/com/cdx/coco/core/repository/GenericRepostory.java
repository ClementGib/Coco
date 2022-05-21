package com.cdx.coco.core.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

/***
 * 
 * @author Clément Gibert
 *
 * @param <T> object type
 * @param <I> id type
 */
public interface GenericRepostory<T, PK extends Serializable> {

	/**
	 * Create an entity object <T> into the database
	 * 
	 * @param entity
	 * @return created entity object
	 */
	T add(T entity);

	/**
	 * Read an entity object <T> into the repository from an id <ID>
	 * 
	 * @param id
	 * @return read entity object
	 */
	Optional<T> findById(PK id);

	/**
	 * Read all entities objects <T> into the repository
	 * 
	 * @param entity
	 * @return all entities objects in a list
	 */
	List<T> findAll();

	/**
	 * Update an entity object <T> into the repository
	 * 
	 * @param entity
	 * @return updated entity object
	 */
	T update(T entity);

	/**
	 * Delete an entity object <T> into the repository
	 * 
	 * @param entity
	 */
	void remove(T entity);

	/**
	 * Returns the Hibernate Session from the EntityManager.
	 * 
	 * @return the Session
	 */
	Session getSession();
}
