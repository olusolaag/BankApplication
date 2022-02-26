/**
 * 
 */
package com.learning.payload.request;

import java.time.LocalDate;
//to be used for : POST /api/customer/register
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:28:54 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	@NotBlank
	private String username;
	@NotBlank
	private String fullName;
	@NotBlank
	private String password;
	
	private LocalDate createdDate = LocalDate.now();

}
