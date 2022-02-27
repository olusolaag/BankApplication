/**
 * 
 */
package com.learning.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:22:20 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Customer extends User{
	private String phone;
	private String pan;
	private String aadhar;
	@OneToMany
	private Set<Account> accounts;

	private String secretQuestion;
	private LocalDate createdDate;
	
	private EnabledStatus status = EnabledStatus.ENABLED;
	private String secretAnswer;
	@OneToMany
	private Set<Beneficiary> beneficiaries;
	
	

}
