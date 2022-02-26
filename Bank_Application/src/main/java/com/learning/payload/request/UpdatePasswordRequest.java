/**
 * 
 */
package com.learning.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 3:35:07 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordRequest {
	private String newPassword;

}
