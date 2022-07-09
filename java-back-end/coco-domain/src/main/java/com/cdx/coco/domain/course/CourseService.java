package com.cdx.coco.domain.course;

import java.util.List;

public interface CourseService {

    /**
     * Find all existing courses and return the informations about them without their content
     * 
     * 
     * @return all the reduced courses without content
     */
    List<Course> findAll();
}
