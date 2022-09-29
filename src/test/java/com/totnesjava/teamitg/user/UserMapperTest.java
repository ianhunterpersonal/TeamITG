package com.totnesjava.teamitg.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserMapperTest {

	@Test
	void entityToResourceAndBack() {
		UserEntity e = UserEntity.builder().email("asd").name("asda").password("asdasda").build();
		UserResource r = UserMapper.INSTANCE.map(e);
		Assertions.assertEquals(e, UserMapper.INSTANCE.map(r));
	}
	
	@Test
	void resourceToEntityAndBack() {
		UserResource r = UserResource.builder().email("asd").name("asda").password("asdasda").build();
		UserEntity e = UserMapper.INSTANCE.map(r);
		Assertions.assertEquals(r, UserMapper.INSTANCE.map(e));
	}
	
	
}
