/**
 * 
 */
package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Staff;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 1:59:04 PM
 */
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
