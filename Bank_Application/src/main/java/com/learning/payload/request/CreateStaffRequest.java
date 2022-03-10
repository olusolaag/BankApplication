/**
 * 
 */
package com.learning.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 1:06:39 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStaffRequest {
	private String staffFullName;
	private String staffUserName;
	private String staffpassword;
	

}
