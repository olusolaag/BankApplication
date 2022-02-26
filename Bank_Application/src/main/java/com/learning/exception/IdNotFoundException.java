/**
 * 
 */
package com.learning.exception;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 10:25:00 AM
 */
public class IdNotFoundException extends Exception {
	public IdNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.getMessage();
	}

}
