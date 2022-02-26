/**
 * 
 */
package com.learning.payload.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

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
 * @time 3:30:32 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretAnswerRequest {
	@NotBlank
	private String answer;

}
