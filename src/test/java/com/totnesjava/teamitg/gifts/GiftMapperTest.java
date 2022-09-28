package com.totnesjava.teamitg.gifts;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.totnesjava.teamitg.gifts.GiftEntity;
import com.totnesjava.teamitg.gifts.GiftMapper;
import com.totnesjava.teamitg.gifts.GiftResource;
import com.totnesjava.teamitg.persons.PersonEntity;

public class GiftMapperTest {

	@Test
	public void testGiftEntityToResource() {
		
		GiftEntity gift = GiftEntity.builder()
				.id("gift_id")
				.title("gift_title")
				.build();
		
		PersonEntity recipient = PersonEntity.builder()
				.id("person_id")
				.email("email")
				.name("name")
				.gifts(Collections.singletonList(gift))
				.build();
		
		gift.setRecipient(recipient);
		
		GiftResource giftResource = GiftMapper.INSTANCE.map(gift);

		Assertions.assertNotNull(giftResource.getRecipientId());
		
	}
}
