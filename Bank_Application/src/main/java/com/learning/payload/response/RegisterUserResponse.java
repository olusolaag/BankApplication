/**
 * 
 */
package com.learning.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 4:15:15 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse {
	private Long id;
	private String userName;
	private String fullName;
	private String password;
	

}
