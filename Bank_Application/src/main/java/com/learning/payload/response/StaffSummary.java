/**
 * 
 */
package com.learning.payload.response;

import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 1:19:23 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffSummary {
	private Long staffId;
	private String staffName;
	private EnabledStatus staus;
	

}
