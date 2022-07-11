package com.cdx.coco.client.mapper;

public interface DTOMapper<M, D> {

    
    /**
     * Maps dto object D to model M
     * 
     * @param dto object
     * @return model object
     */
    M toModel(D dto);

    /**
     * Maps model object M to dto D
     * 
     * @param model object
     * @return dto object
     */
    D toDTO(M model);
    
}
