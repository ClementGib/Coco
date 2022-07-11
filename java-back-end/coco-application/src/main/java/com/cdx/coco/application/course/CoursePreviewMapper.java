package com.cdx.coco.application.course;

import com.cdx.coco.application.mapper.ModelMapper;
import com.cdx.coco.domain.course.CoursePreview;

public class CoursePreviewMapper implements ModelMapper<CoursePreview, CourseEntity> {

    @Override
    public CoursePreview toModel(CourseEntity entity) {
        return new CoursePreview.Builder(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .introduction(entity.getIntroduction())
                .description(entity.getDescription())
                .creationDate(entity.getCreationDate())
                .likeCount(entity.getLikeCount())
                .imageId(entity.getImageId())
                .build();
    }

    @Override
    public CourseEntity toEntity(CoursePreview model) {
        CourseEntity entity = new CourseEntity();
        entity.setId(model.id());
        entity.setTitle(model.title());
        entity.setAuthor(model.author());
        entity.setIntroduction(model.introduction());
        entity.setDescription(model.description());
        entity.setCreationDate(model.creationDate());
        entity.setLikeCount(model.likeCount());
        entity.setImageId(model.imageId());
        return entity;
    }
}
