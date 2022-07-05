package com.cdx.coco.api.course;

import java.util.List;

public interface CourseService {

    /**
     * Find all existing courses and return them without the content
     * 
     * 
     * @return all the courses information without the details
     */
    List<Course> findAll();
}
