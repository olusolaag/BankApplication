/**
 * 
 */
package com.learning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Customer;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 2:00:01 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Optional<Customer> findByUsername(String username);

}
