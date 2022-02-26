/**
 * 
 */
package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Role;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 2:01:50 PM
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
