package com.totnesjava.teamitg.exceptions;

public class UserNotAuthenticatedException extends RuntimeException {

	private static final long serialVersionUID = 6066106264696685322L;

	public UserNotAuthenticatedException(String username) {
		super("User not authenticated: " + username + "'");
	}
	
}
