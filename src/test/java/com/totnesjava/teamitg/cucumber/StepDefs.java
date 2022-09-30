package com.totnesjava.teamitg.cucumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.totnesjava.teamitg.user.UserEntity;
import com.totnesjava.teamitg.user.UserMapper;
import com.totnesjava.teamitg.user.UserRepository;
import com.totnesjava.teamitg.user.UserResource;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs extends AbstractSteps {

	@Given("I clear the {string} database")
	public void i_clear_the_database(String tableName) {
		userRepository.deleteAll();
	}

	@Given("I have {long} users")
	public void i_have_users(Long userCount) {
		Assertions.assertEquals(userCount, userRepository.count(), "Wrong number of users in database");
	}

	@When("I create users")
	public void i_create_users(List<UserEntity> users) {
		users.forEach(user -> {
			super.callRestPost("/v1/users", user, UserResource.class);
			Assertions.assertEquals(HttpStatus.CREATED.value(), super.lastHttpStatus, "Wrong HTTP Status code");
		});
	}

	@When("I delete user with email {string}")
	public void i_delete_user_with_email(String email) {
		userRepository.deleteByEmail(email);
	}

	@Then("User exists")
	public void user_exists(List<UserEntity> users) {
		users.forEach(u -> {
			UserEntity fromDb = userRepository.findByEmail(u.getEmail());
			Assertions.assertNotNull(fromDb);
			Assertions.assertEquals(u, fromDb, "User in DB does not match expectation from test");
		});
	}

	@SuppressWarnings("unchecked")
	@When("I list all users")
	public void i_list_all_users() {
		lastFetchedUsers = super.callRestGet("/v1/users", List.class);
	}

	@Then("I get users")
	public void i_get_users(List<UserResource> expectedUsers) {
		Assertions.assertEquals(expectedUsers.size(), (lastFetchedUsers != null) ? lastFetchedUsers.size() : 0);
		if (lastFetchedUsers != null) {
			Assertions.assertEquals(sortResources(expectedUsers), sortResources(expectedUsers));
		}
		;
	}

	private List<UserResource> sortResources(List<UserResource> input) {
		return input.stream().sorted(Comparator.comparing(UserResource::getEmail)).collect(Collectors.toList());
	}

	private List<UserResource>	lastFetchedUsers;

	@Autowired
	protected UserRepository	userRepository;

}
