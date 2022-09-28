package com.totnesjava.teamitg.testData;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.totnesjava.teamitg.gifts.GiftEntity;
import com.totnesjava.teamitg.persons.PersonEntity;
import com.totnesjava.teamitg.persons.PersonRepository;
import com.totnesjava.teamitg.persons.PersonService;

@Component
public class TestDataInserter {

	@PostConstruct
	private void addTestData() {

		if (personRepository.count() == 0) {
			PersonEntity toSave1 = PersonEntity.builder().name("_Test_Person_1").email("_Test_Person_1@email.com").password("xxx").build();
			toSave1.getGifts().add(GiftEntity.builder().title("_TEST_Gift_1_1").description("_TEST_Descr_1_1").build());
			toSave1.getGifts().add(GiftEntity.builder().title("_TEST_Gift_1_2").description("_TEST_Descr_1_2").build());
			toSave1.getGifts().add(GiftEntity.builder().title("_TEST_Gift_1_3").description("_TEST_Descr_1_3").build());
			toSave1.getGifts().add(GiftEntity.builder().title("_TEST_Gift_1_4").description("_TEST_Descr_1_4").build());

			personService.save(toSave1);

			PersonEntity toSave2 = PersonEntity.builder().id(UUID.randomUUID().toString()).name("_Test_Person_2").password("xxx").email("_Test_Person_2@email.com").build();
			toSave2.getGifts().add(GiftEntity.builder().title("_TEST_Gift_2_1").description("_TEST_Descr_2_1").build());
			toSave2.getGifts().add(GiftEntity.builder().title("_TEST_Gift_2_2").description("_TEST_Descr_2_2").build());
			toSave2.getGifts().add(GiftEntity.builder().title("_TEST_Gift_2_3").description("_TEST_Descr_2_3").build());
			toSave2.getGifts().add(GiftEntity.builder().title("_TEST_Gift_2_4").description("_TEST_Descr_2_4").build());

			personService.save(toSave2);
		}

	}

	@Autowired
	private PersonService	personService;

	@Autowired
	private PersonRepository	personRepository;


}
