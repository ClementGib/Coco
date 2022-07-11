package com.cdx.coco.application.course;

import java.util.List;

import com.cdx.coco.domain.repository.GenericRepostory;

/***
 * specific dao interface for courses
 * 
 * @author Clément Gibert
 *
 */
public interface CourseRepository extends GenericRepostory<CourseEntity, Integer> {

    /**
     * Find all existing course entities
     * 
     * 
     * @return all the course entities
     */
    List<CourseEntity> findAll();
}
