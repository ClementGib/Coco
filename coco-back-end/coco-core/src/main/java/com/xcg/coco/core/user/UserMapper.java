package com.xcg.coco.core.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
	
//	@Mapping(source = "username", target = "username", qualifiedByName = "moneyString")
//	@Mapping(source = "password", target = "password", qualifiedByName = "moneyString")
//	@Mapping(source = "username", target = "username", qualifiedByName = "moneyString")
	UserDTO mapToDTO(UserEntity user);
	
	
	
	UserEntity mapToEntity(UserDTO user);

}
