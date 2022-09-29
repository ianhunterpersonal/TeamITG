package com.totnesjava.teamitg.user;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Test
	public void testRetrievePersons() {
		
		List<UserEntity> entities = Arrays.asList(UserEntity.builder().build());
		when(mockRepository.findAll()).thenReturn(entities);
		
		List<UserResource> expectedResources = entities.stream().map(e -> UserMapper.INSTANCE.map(e)).collect(Collectors.toList());
		
		List<UserResource> actualResults = sut.findAll();
		
		Assertions.assertEquals(expectedResources, actualResults);
		
		Mockito.verify(mockRepository).findAll();
		
	}

	@Test
	public void testFindById() {

		UserEntity entity = UserEntity.builder().id("ID").build();
		when(mockRepository.findById("ID")).thenReturn(Optional.of(entity));

		UserEntity fromDb = UserMapper.INSTANCE.map(sut.findById("ID"));
		
		Assertions.assertEquals(entity, fromDb);
		
	}
	
	@Test
	public void testFindByIdWhenNotPresent() {

		String id = "dont_care";

		RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
			sut.findById(id);
		});
		
		Assertions.assertEquals("User not found ID =" + id, exception.getMessage());
		
	}
	

	@Mock
	private UserRepository	mockRepository;

	@InjectMocks
	private UserService		sut;

}
