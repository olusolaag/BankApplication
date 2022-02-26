/**
 * 
 */
package com.learning.payload.response;

import java.time.LocalDate;

import com.learning.enums.AccountType;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 11:18:45 AM
 */
public class AccountCreationResponse {
	private AccountType accountType;
	private double accountBalance;
	private String approved ="No";
	private long accountNumber;
	private LocalDate dateOfCreation;
	private Long customerId;
	
	
	
	

}
