/**
 * 
 */
package com.learning.payload.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.learning.entity.Account;
import com.learning.entity.Customer;
import com.learning.entity.Transaction;
import com.learning.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 3:25:41 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestStaff {
	@Min(0)
	private Long fromAccountNumber;
	@Min(0)
	private Long toAccountNumber;
	@DecimalMin("0.01")
	private double amount;
	
	private String reason;
	@NotNull
	private String staff;
	

}
