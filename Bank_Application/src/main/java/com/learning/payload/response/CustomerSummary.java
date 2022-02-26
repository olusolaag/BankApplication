/**
 * 
 */
package com.learning.payload.response;

import java.time.LocalDate;

import com.learning.enums.EnabledStatus;

import lombok.Data;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 12:47:17 PM
 */
@Data
public class CustomerSummary {
	private long customerId;
	private String customerName;
	private EnabledStatus status;
	private LocalDate createdDate;

}
