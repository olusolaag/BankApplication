/**
 * 
 */
package com.learning.serviceImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Role;
import com.learning.entity.Staff;
import com.learning.enums.RoleName;
import com.learning.exception.NoDataFoundException;
import com.learning.payload.request.CreateStaffRequest;
import com.learning.payload.request.SetEnabledRequest;
import com.learning.repo.StaffRepository;
import com.learning.service.AdminService;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 5:51:13 PM
 */
public class AdminServiceImpl implements AdminService {

	@Autowired
	StaffRepository staffRepo;

	@Override
	public String createStaff(CreateStaffRequest request) {
		Staff staff = new Staff();
		staff.setFullName(request.getStaffFullName());
		staff.setPassword(request.getStaffpassword());
		staff.setUsername(request.getStaffUserName());
		staff.setRoles(new HashSet<Role>());
		staff.getRoles().add(new Role(2,RoleName.STAFF));
		staffRepo.save(staff);
		return "Staff created";
	}

	@Override
	public List<Staff> getAllStaff() {
		List<Staff> staff = staffRepo.findAll();
		return staff;
	}

	@Override
	public String setEnabled(SetEnabledRequest request) {
		Staff staff = staffRepo.findById(request.getId()).orElseThrow(()->new NoDataFoundException("Staff not found"));
		staff.setStatus(request.getStatus());
		staffRepo.save(staff);
		return "Staff status updated";
	}


}
