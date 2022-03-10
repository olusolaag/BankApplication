/**
 * 
 */
package com.learning.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.learning.enums.AccountType;
import com.learning.enums.EnabledStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 1:14:45 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	private AccountType accountType;
	private double accountBalance;
	private String approved;
	private LocalDate dateOfCreation;
	private EnabledStatus accountStatus;
	@ManyToOne
	@NotNull
	private Customer customer;
	@OneToMany
	private List<Transaction> transaction;
	
}
