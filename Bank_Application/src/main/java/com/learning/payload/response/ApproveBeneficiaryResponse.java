/**
 * 
 */
package com.learning.payload.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 3:45:11 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApproveBeneficiaryResponse {
	private long fromCustomer;
	private LocalDate beneficiaryAddedDate;
	private long beneficiaryAccount;
	private String approved="Yes";
}
