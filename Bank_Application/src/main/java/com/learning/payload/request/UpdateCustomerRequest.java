/**
 * 
 */
package com.learning.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Mar 8, 2022
 * @time 3:13:55 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
	private String fullname;
	private String phone;
	private String pan;
	private String aadhar ;
	private String secretQuestion;
	private String secretAnswer;
	private String panImage;
	private String aadharImage;
}
