/**
 * 
 */
package com.learning.payload.request;


//to be used: GET /api/staff/customer
import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 12:55:49 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusUpdateRequest {
	private long id;
	private EnabledStatus status;

}
