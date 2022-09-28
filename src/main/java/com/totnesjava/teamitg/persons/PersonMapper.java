package com.totnesjava.teamitg.persons;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.totnesjava.teamitg.gifts.GiftMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, uses = {GiftMapper.class})
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
	
   PersonResource map(PersonEntity entity);
   
   PersonEntity map(PersonResource entity);
   
}
