package com.captaincode.lendingengine.domain.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String userId) {
		super("User with id " + userId + " was not found");
	
	}	
}
