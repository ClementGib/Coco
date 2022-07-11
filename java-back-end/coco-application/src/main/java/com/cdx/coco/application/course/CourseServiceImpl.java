package com.cdx.coco.application.course;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.cdx.coco.domain.course.Course;
import com.cdx.coco.domain.course.CoursePreview;
import com.cdx.coco.domain.course.CourseService;

public class CourseServiceImpl implements CourseService {

    @Inject
    CourseRepository courseRepository;

    @Inject
    CourseMapper courseMapper;

    @Inject
    CoursePreviewMapper coursePreviewMapper;

    @Override
	public List<CoursePreview> findAll() {
	    return courseRepository.findAll()
	            .stream()
	            .map(coursePreviewMapper::toModel)
	            .collect(Collectors.toList());
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return courseRepository.findById(id).map(courseMapper::toModel);
    }

    @Override
    public Optional<Course> findByCategory(String Categoryname) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
}
