package com.totnesjava.teamitg.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

	@BeforeEach
	public void beforeEachTest() {
		Assertions.assertEquals(0, sut.count());
	}

	/**
	 * Doesnt do anything except loads the schema and insert a record, and read
	 * back. This simply tests that the FlyWay migrations work.
	 */
	@Test
	public void testSchema() {
		
		UserEntity toSave = UserEntity.builder()
				.name("name")
				.email("email")
				.build();

		
		toSave = sut.save(toSave);
		Assertions.assertEquals(1, sut.count());

		UserEntity fromDb = sut.findById(toSave.getId()).get();
		Assertions.assertEquals(toSave, fromDb);

	}

	@Autowired
	private UserRepository sut;


}
