/**
 * 
 */
package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Account;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 2:52:39 PM
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findAllByApproved(String approved);
}
