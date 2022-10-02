package com.totnesjava.teamitg.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,String> {

	UserEntity findByEmail(String email);

	UserEntity findByName(String name);
	
	void deleteByEmail(String email);

	UserEntity findByEmailAndPassword(String email, String password);

}
