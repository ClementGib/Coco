package com.cdx.coco.domain.category;

import java.util.List;

public interface CategoryService {

    /**
     * Find all existing categories and return them
     * 
     * 
     * @return all the existing categories
     */
    List<Category> findAll();
    
}
