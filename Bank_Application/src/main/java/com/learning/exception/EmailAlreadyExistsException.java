package com.learning.exception;

public class EmailAlreadyExistsException extends Exception {
	public EmailAlreadyExistsException (String e) {
		super(e);
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}
}
