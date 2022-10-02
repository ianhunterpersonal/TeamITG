package com.totnesjava.teamitg;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.totnesjava.teamitg.user.UserEntity;
import com.totnesjava.teamitg.user.UserRepository;
import com.totnesjava.teamitg.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Profile("withTestData")
@Component
@Slf4j
public class TestDataInserter {

	@PostConstruct
	private void addTestData() {

		log.info("Adding test data if it doesn exist...");
		if (!userRepository.existsByEmail("root@email.com")) {
			userService.save(UserEntity.builder().name("root").email("root@email.com").password("root").build());
			log.info("Added user root");
		}
		
		if (!userRepository.existsByEmail("ian@email.com")) {
			userService.save(UserEntity.builder().name("ian").email("ian@email.com").password("ian").build());
			log.info("Added user ian");
		}

		if (!userRepository.existsByEmail("louise@email.com")) {
			userService.save(UserEntity.builder().name("louise").email("louise@email.com").password("louise").build());
			log.info("Added user louise");
		}

		if (!userRepository.existsByEmail("sarah@email.com")) {
			userService.save(UserEntity.builder().name("sarah").email("sarah@email.com").password("sarah").build());
			log.info("Added user sarah");
		}

	}

	@Autowired
	private UserService		userService;

	@Autowired
	private UserRepository	userRepository;

}
