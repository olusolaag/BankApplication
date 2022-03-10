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
 * @time 1:48:42 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApproveAccountResponse {
	private long accountNumber;
	private String approved ="yes";

}
