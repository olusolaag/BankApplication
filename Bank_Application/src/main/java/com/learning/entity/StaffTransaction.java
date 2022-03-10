/**
 * 
 */
package com.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 5:28:48 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffTransaction extends Transaction {
	private String byStaff;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
