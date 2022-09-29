package com.totnesjava.teamitg.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
	
   UserResource map(UserEntity entity);
   
   UserEntity map(UserResource entity);
   
}
