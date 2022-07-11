package com.cdx.coco.domain.course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    /**
     * Find all existing courses and return the preview without their content
     * 
     * 
     * @return the preview of all courses
     */
    List<CoursePreview> findAll();
    
    /**
     * Find the course if it exists from its Id
     * 
     * @param unique course id
     * 
     * @return an {@link Optional} containing the course if it exists
     */
    Optional<Course> findById(Integer id);
    
    /**
     * Find all courses from category
     * 
     * @param category name
     * 
     * @return an {@link Optional} containing the course if it exists
     */
    Optional<Course> findByCategory(String Categoryname);
}
