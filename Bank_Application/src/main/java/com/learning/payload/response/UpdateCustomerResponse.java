/**
 * 
 */
package com.learning.payload.response;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 2:53:11 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerResponse {
	private long customerId;

	private String fullName;
	
	private String phone;
	
	private String pan;
	private String panImage;
	
	private String aadhar;
	private String aadharImage;
	
	private String secretQuestion;
	
	private String secretAnswer;

}
