/**
 * 
 */
package com.learning.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.learning.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "Olusola Agboola"
 * @date Feb 19, 2022
 * @time 2:59:43 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private LocalDate date;
	private String reference;
	private double amount;
	private TransactionType transactionType;
	@NotNull
	@ManyToOne
	private Account account;

}
