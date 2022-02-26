/**
 * 
 */
package com.learning.payload.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

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
public class ApproveBeneficiaryRequest {
	private long fromCustomer;
	@NotNull
	private LocalDate beneficiaryAddedDate;
	private long beneficiaryAccount;
	private String approved="Yes";
}
