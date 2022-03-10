/**
 * 
 */
package com.learning.service;

import java.util.List;

import com.learning.entity.Staff;
import com.learning.payload.request.CreateStaffRequest;
import com.learning.payload.request.SetEnabledRequest;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 5:47:36 PM
 */
public interface AdminService {
	String createStaff(CreateStaffRequest reqeust);
	List<Staff> getAllStaff();
	String setEnabled (SetEnabledRequest request);
}
