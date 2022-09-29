package com.totnesjava.teamitg.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserEntityResourceMapperTest {

	@Test
	public void testEntityToResource() {
		
		UserEntity entity = UserEntity.builder()
				.id("_id_")
				.name("name")
				.email("email")
				.build();
		
		UserResource resource = UserMapper.INSTANCE.map(entity);
		
		Assertions.assertEquals(entity.getId(),   resource.getId());
		Assertions.assertEquals(entity.getName(), resource.getName());
		Assertions.assertEquals(entity.getEmail(), resource.getEmail());

	}
	
	@Test
	public void testResourceToEntity() {
		
		UserResource resource = UserResource.builder()
				.id("_id_")
				.name("name")
				.email("email")
				.build();
		
		UserEntity entity = UserMapper.INSTANCE.map(resource);
		
		Assertions.assertEquals(resource.getId(),   entity.getId());
		Assertions.assertEquals(resource.getName(), entity.getName());
		Assertions.assertEquals(resource.getEmail(), entity.getEmail());
		
	}
	
}
