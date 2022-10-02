package com.totnesjava.teamitg.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "Resource representing login credentials")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserCredentialsResource {

	@Schema(description = "The email as the identifier of credentials", example = "test@mail.com")
	private String email;
	
	@Schema(description = "The password for the user", example = "secret")
	private String password;
	
}
