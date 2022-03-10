/**
 * 
 */
package com.learning.payload.response;

import java.util.List;

import com.learning.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 4:20:16 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsStaffResponse {
	private long accountNumber;
	private String customer;
	private double accountBalance;
	private List<Transaction> transaction;
}
