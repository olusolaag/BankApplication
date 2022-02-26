/**
 * 
 */
package com.learning.payload.request;
//

import com.learning.enums.AccountType;
import com.learning.enums.IsActive;

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
	private long accountNumber;
	private AccountType accountType;
	private IsActive active;

}
