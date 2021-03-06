/**
 * 
 */
package com.learning.payload.request;

import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 4:28:37 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetEnabledRequest {
	private Long id;
	private EnabledStatus status;


}
