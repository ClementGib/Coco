package com.cdx.coco.application.category;

import javax.inject.Inject;

import com.cdx.coco.application.mapper.ModelMapper;
import com.cdx.coco.domain.category.Category;
import com.cdx.coco.domain.course.CourseService;

public class CategoryMapper implements ModelMapper<Category, CategoryEntity> {
    
    @Inject
    CourseService courseService;

    @Override
    public Category toModel(CategoryEntity entity) {
        return new Category.Builder(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public CategoryEntity toEntity(Category model) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(model.name());
        entity.setDescription(model.description());
//        entity.setCourses(null);
         return entity;
    }

}
