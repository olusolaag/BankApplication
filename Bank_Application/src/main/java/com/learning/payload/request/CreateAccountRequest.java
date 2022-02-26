/**
 * 
 */
package com.learning.payload.request;
//to be used for : POST /api/customer/register

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.learning.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:37:13 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
	@NotNull
	private AccountType accountType;
	private double accountBalance;
	@NotBlank
	private String approved;

}
