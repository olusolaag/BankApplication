/**
 * 
 */
package com.learning.payload.response;

import java.util.List;

import com.learning.entity.Transaction;
import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.learning.enums.AccountType;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 2:57:43 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsResponse {
	private long accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private EnabledStatus enabledStatus;
	private List<Transaction> transaction;

}
