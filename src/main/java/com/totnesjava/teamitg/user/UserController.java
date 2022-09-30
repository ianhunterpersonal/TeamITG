package com.totnesjava.teamitg.user;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.totnesjava.teamitg.exceptions.EntityNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApiResponses(value = {
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Void.class)))
})
@AllArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Operation(summary = "Recovers Users from the database using optional filters as arguments")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Persons listed",
					content = @Content(mediaType = "application/json",array = @ArraySchema(schema = @Schema(implementation = UserResource.class)))
			)
	})
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<UserResource>> fetchAll(@RequestParam(required = false) String email) {
		log.info("fetchAll persons");
		List<UserResource> allPersons = service.findAll().stream().filter(pe -> ((email == null) || pe.getEmail().equals(email))).collect(Collectors.toList());
		return ResponseEntity.ok(allPersons);
	}

	@Operation(summary = "Create a new user with given attributes.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201", description = "Person created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResource.class))
			)
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<UserResource> add(@RequestBody UserResource personResource) {
		UserResource toReturn = service.save(UserMapper.INSTANCE.map(personResource));
		return ResponseEntity.created(URI.create("")).body(toReturn);
	}

	@Operation(summary = "Deletes person with given ID")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200", description = "Person deleted"
			), @ApiResponse(
					responseCode = "404", description = "Person not found"
			)
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		try {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException enfe) {
			return ResponseEntity.notFound().build();
		}
	}

	private UserService service;

}
