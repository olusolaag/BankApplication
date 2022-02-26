/**
 * 
 */
package com.learning.payload.request;

//to be used: POST /api/customer/:customerId/account/:accountId

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:42:06 PM
 */
public class ApproveAccountRequest {
	@Min(1)
	private long accountNumber;
	@NotBlank
	private String approved = "Yes";

}
