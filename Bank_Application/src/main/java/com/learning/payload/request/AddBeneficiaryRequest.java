/**
 * 
 */
package com.learning.payload.request;
//

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.learning.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 12:27:23 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBeneficiaryRequest {
	@Min(1)
	private long accountNumber;
	@NotNull
	private AccountType accountType;
	private String approved;

}
