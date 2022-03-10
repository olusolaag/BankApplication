/**
 * 
 */
package com.learning.payload.response;

import com.learning.enums.IsActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 11:35:58 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarySummary {
	private Long beneficiaryId;
	private Long beneficiaryAccountNumber;
	private String beneficiaryName;
	private IsActive active;

}
