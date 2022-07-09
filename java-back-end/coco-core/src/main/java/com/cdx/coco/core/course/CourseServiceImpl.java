package com.cdx.coco.core.course;

import java.util.List;

import javax.inject.Inject;

import com.cdx.coco.domain.course.Course;
import com.cdx.coco.domain.course.CourseService;

public class CourseServiceImpl implements CourseService {

	@Inject
	CourseRepository courseRepository; 
	
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
