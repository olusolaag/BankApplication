package com.learning.exception;

public class UserNotFoundException extends RuntimeException  {

	public UserNotFoundException(Long userId) {
		super("Sorry user With " + userId + " not found");
	}
}
