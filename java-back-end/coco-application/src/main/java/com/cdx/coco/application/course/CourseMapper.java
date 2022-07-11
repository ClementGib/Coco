package com.cdx.coco.application.course;

import com.cdx.coco.application.mapper.ModelMapper;
import com.cdx.coco.domain.course.Course;

public class CourseMapper implements ModelMapper<Course, CourseEntity> {

    @Override
    public Course toModel(CourseEntity courseEntity) {
        return new Course.Builder(courseEntity.getId())
                .title(courseEntity.getTitle())
                .author(courseEntity.getTitle())
                .introduction(courseEntity.getIntroduction())
                .description(courseEntity.getDescription())
                .creationDate(courseEntity.getCreationDate())
                .likeCount(courseEntity.getLikeCount())
                .imageId(courseEntity.getImageId())
//                .pages(courseEntity.getPages())
//                .categories(courseEntity.getCategories())
                .build();
        
        
    }

    @Override
    public CourseEntity toEntity(Course model) {
        // TODO Auto-generated method stub
        return null;
    }

}
