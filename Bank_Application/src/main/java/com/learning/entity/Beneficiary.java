/**
 * 
 */
package com.learning.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.learning.enums.AccountType;
import com.learning.enums.IsActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 3:17:18 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long beneficiaryId;
	private long accountNo;
	private AccountType accountType;
	private String approved ="no";
	private String name;
	private IsActive isActive;
	private LocalDate addedDate;

}
