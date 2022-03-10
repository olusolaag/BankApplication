/**
 * 
 */
package com.learning.exception;

/**
 * @author "Olusola Agboola"
 * @date Mar 5, 2022
 * @time 11:29:33 AM
 */
public class AccountCreationException extends RuntimeException {
	public AccountCreationException (String e) {
		super(e);
	}
	
	@Override
	public String toString() {
		return super.getMessage();
	}

}
