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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:22:20 PM
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Customer extends User{
	@NotBlank
	private String phone;
	private String pan;
	private String aadhar;
	@OneToMany
	private Set<Account> accounts;
	@NotBlank
	private String secretQuestion;
	private LocalDate createdDate;
	
	private EnabledStatus status = EnabledStatus.ENABLED;
	
	@NotBlank
	private String secretAnswer;
	@OneToMany
	private Set<Beneficiary> beneficiaries;
	
	

}
