/**
 * 
 */
package com.learning.payload.response;

import java.time.LocalDate;

import com.learning.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 11:18:45 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreationResponse {
	private AccountType accountType;
	private double accountBalance;
	private String approved ="No";
	private long accountNumber;
	private LocalDate dateOfCreation;
	private Long customerId;
}
