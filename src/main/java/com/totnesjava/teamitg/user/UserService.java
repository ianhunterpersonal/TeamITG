package com.totnesjava.teamitg.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totnesjava.teamitg.exceptions.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	
	public UserResource save(UserEntity userEntity) {
		return UserMapper.INSTANCE.map(repository.save(userEntity));
	}

	public UserResource findById(String id) {
		Optional<UserEntity> result = repository.findById(id);
		if (!result.isPresent()) throw new EntityNotFoundException("User not found ID =" + id);
		return(UserMapper.INSTANCE.map(result.get()));
	}

	public void deleteById(String id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("User not found ID =" + id);
		}
	}

	public List<UserResource> findAll() {
		return repository.findAll().stream().map(e -> UserMapper.INSTANCE.map(e)).collect(Collectors.toList());
	}

	public UserResource login(UserCredentialsResource credentialsResource) {
		UserEntity userEntity = repository.findByEmailAndPassword(credentialsResource.getEmail(), credentialsResource.getPassword());
		if (userEntity == null) {
			throw new EntityNotFoundException("User not found ID =" + credentialsResource.getEmail());
		}
		return UserMapper.INSTANCE.map(userEntity);
	}

	@Autowired
	private UserRepository repository; // Autowired via constructor


}
