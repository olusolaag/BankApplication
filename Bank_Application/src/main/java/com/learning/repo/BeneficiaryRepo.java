/**
 * 
 */
package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Beneficiary;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 4:46:10 PM
 */
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {
	List<Beneficiary> findAllByApproved(String approved);

}
