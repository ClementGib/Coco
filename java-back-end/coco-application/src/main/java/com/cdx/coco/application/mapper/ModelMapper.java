package com.cdx.coco.application.mapper;

public interface ModelMapper <M, E> {

    
    /**
     * Maps entity object E to model M
     * 
     * @param entity object
     * @return model object
     */
    M toModel(E entity);

    /**
     * Maps model object M to entity E
     * 
     * @param model object
     * @return entity object
     */
    E toEntity(M model);

}
