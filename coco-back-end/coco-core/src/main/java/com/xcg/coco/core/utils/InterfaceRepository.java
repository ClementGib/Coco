package com.xcg.coco.core.utils;

import java.io.Serializable;
import java.util.Optional;

public interface InterfaceRepository <E, ID extends Serializable> {

	/**
	 * Create entity into database
	 * @param entity
	 * @return
	 */
	E create(E entity);
	
	/**
	 * Delete entity into database
	 * @param entity
	 */
	void delete(E entity);
	
	
	/**
	 * Save an entity into database
	 * @param entity
	 * @return
	 */
	E save(E entity);
	
	/**
	 * find optional entity corresponding to an id
	 * @param id
	 * @return
	 */
	Optional<E> findById(ID id);
	
}
