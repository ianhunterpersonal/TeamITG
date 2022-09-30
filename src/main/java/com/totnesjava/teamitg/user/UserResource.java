package com.totnesjava.teamitg.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "Resource representing a user of the system")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResource {

	@Schema(description = "The ID of the person as a GUID", example = "GUID")
	private String id;
	
	@Schema(description = "Full name of the user", example = "Ian Hunter")
	private String name;
	
	@Schema(description = "The valid email address of the user", example = "test@mail.com")
	private String email;
	
	@Schema(description = "The password for the user", example = "secret")
	private String password;
	
	@Schema(description = "Token assigned when user logged in", example = "0a772b0c-1e5c-4725-94c9-d275724670ec")
	private String loginToken;
	
}
