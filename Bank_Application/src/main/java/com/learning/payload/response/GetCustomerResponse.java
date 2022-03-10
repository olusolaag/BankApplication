/**
 * 
 */
package com.learning.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 2:25:31 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {
	private String userName;
	private String fullName;
	private String phone;
	private String pan;
	private String aadhar;
}
