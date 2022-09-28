package com.totnesjava.teamitg.sessions;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totnesjava.teamitg.exceptions.PersonNotAuthenticatedException;
import com.totnesjava.teamitg.persons.PersonMapper;
import com.totnesjava.teamitg.persons.PersonResource;
import com.totnesjava.teamitg.persons.PersonService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Service
public class SessionService {
	
	@Autowired
	public SessionService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonResource login(Credentials credentials) throws PersonNotAuthenticatedException {
		PersonResource result = personService.findByCredentials(credentials);
		if (result == null) {
			throw new PersonNotAuthenticatedException(credentials.getEmail());
		}
		
		result.setLoginToken(UUID.randomUUID().toString());
		personService.save(PersonMapper.INSTANCE.map(result));
		return result;
	}

	private PersonService personService;
	
}
