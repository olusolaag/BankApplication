/**
 * 
 */
package com.learning.payload.response;

import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.learning.enums.AccountType;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:49:50 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSummaryResponse {
	private long accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private EnabledStatus enabledStatus;

}
