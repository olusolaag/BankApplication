/**
 * 
 */
package com.learning.payload.request;
//to be used for : POST /api/customer/authenticate
//to be used for : POST /api/staff/authenticate
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:33:48 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateRequest {
	@NotBlank
	private String userName;
	@NotBlank
	private String password;
}
