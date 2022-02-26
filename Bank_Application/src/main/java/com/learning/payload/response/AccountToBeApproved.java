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
 * @date Feb 26, 2022
 * @time 12:06:53 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountToBeApproved {
	private String accountType;
	private String customerName;
	private LocalDate accountNumber;
	private String approved="No";
}
