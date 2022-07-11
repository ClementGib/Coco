package com.cdx.coco.client.facade.courses;

import com.cdx.coco.client.mapper.DTOMapper;
import com.cdx.coco.domain.course.CoursePreview;

public class CoursePreviewDTOMapper implements DTOMapper<CoursePreview, CoursePreviewDTO> {

    @Override
    public CoursePreview toModel(CoursePreviewDTO dto) {
        return new CoursePreview.Builder(dto.id())
                .title(dto.title())
                .author(dto.author())
                .introduction(dto.introduction())
                .description(dto.description())
                .creationDate(dto.creationDate())
                .likeCount(dto.likeCount())
                .imageId(dto.imageId())
                .build();
    }

    @Override
    public CoursePreviewDTO toDTO(CoursePreview model) {
        return new CoursePreviewDTO.Builder(model.id())
                .title(model.title())
                .author(model.author())
                .introduction(model.introduction())
                .description(model.description())
                .creationDate(model.creationDate())
                .likeCount(model.likeCount())
                .imageId(model.imageId())
                .build();
    }
}
