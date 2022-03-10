/**
 * 
 */
package com.learning.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.payload.request.AddBeneficiaryRequest;
import com.learning.payload.request.ApproveAccountRequest;
import com.learning.payload.request.CreateAccountRequest;
import com.learning.payload.request.SecretAnswerRequest;
import com.learning.payload.request.TransferRequest;
import com.learning.payload.request.UpdateCustomerRequest;
import com.learning.payload.request.UpdatePasswordRequest;
import com.learning.payload.response.AccountCreationResponse;
import com.learning.payload.response.AccountDetailsResponse;
import com.learning.payload.response.AccountSummaryResponse;
import com.learning.payload.response.ApproveAccountResponse;
import com.learning.payload.response.BeneficiarySummary;
import com.learning.payload.response.GetCustomerResponse;
import com.learning.payload.response.UpdateCustomerResponse;
import com.learning.service.CustomerService;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 2:19:50 PM
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@PostMapping("/:customerID/account")
	public ResponseEntity<?> createAccount(@Valid @PathVariable("customerID") Long customerId, @RequestBody CreateAccountRequest request){
		AccountCreationResponse result = customerService.addAccount(customerId, request);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/:customerID/account/:accountNo")
	public ResponseEntity<?> approveAccount(@PathVariable("customerID") Long customerID, @PathVariable("accountNo") Long accountNo, @RequestBody ApproveAccountRequest request){
		ApproveAccountResponse result = customerService.approveAccount(customerID, accountNo, request);
		return ResponseEntity.status(200).body(result);
	}
	
	@GetMapping("/:customerID/account")	
	public  ResponseEntity<?> getAllAccounts(@PathVariable("customerID") Long customerID){
		List<AccountSummaryResponse> response = customerService.getCustomerAccounts(customerID);
		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping("/:customerID/account")	
	public  ResponseEntity<?>  getCustomer(@PathVariable("customerID") Long customerID){
		GetCustomerResponse response = customerService.getCustomer(customerID);
		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping("/:customerID/account/accountID")
	public  ResponseEntity<?> getCustomerAccount(@PathVariable("customerID") Long customerID, @PathVariable("accountID") Long accountID){
		AccountDetailsResponse response = customerService.getCustomerAccount(customerID, accountID);
		return ResponseEntity.status(200).body(response);
	}
	@PutMapping("/:customerId")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") Long customerId, @Valid @RequestBody UpdateCustomerRequest request){
		UpdateCustomerResponse response = customerService.updateCustomer(customerId, request);
		return ResponseEntity.status(200).body(response);
	}
	
	@PostMapping("/:customerID/beneficiary")
	public ResponseEntity<?> addBeneficiary(@Valid @PathVariable("customerID") Long customerId, @RequestBody AddBeneficiaryRequest request){
		return ResponseEntity.ok(customerService.addBeneficiary(customerId, request));
	}
	
	@GetMapping("/:customerID/beneficiary")
	public  ResponseEntity<?> getBeneficiaries(@PathVariable("customerID") Long customerID){
		List<BeneficiarySummary> response = customerService.getBeneficiaries(customerID);
		return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping("/:customerID/beneficiary/:beneficiaryID")
	public  ResponseEntity<?> deleteBeneficiary(@PathVariable("customerID") Long customerID, @PathVariable("beneficiaryID") Long beneficiaryID){
			return ResponseEntity.status(200).body(customerService.deleteBeneficiary(customerID, beneficiaryID));		
	}
	

	@PutMapping("/transfer")
	public ResponseEntity<?> transferFunds(@Valid @RequestBody TransferRequest request){
		return ResponseEntity.status(200).body(customerService.transferFunds(request));
	}

	@GetMapping("/:username/forgot/question")
	public ResponseEntity<?> getQuestion(@PathVariable("username") String username){
		return ResponseEntity.ok(customerService.getQuestion(username));
	}
	
	@GetMapping("/:username/forgot/answer")
	public ResponseEntity<?> getQuestion(@PathVariable("username") String username, @RequestBody SecretAnswerRequest request){
		return ResponseEntity.ok(customerService.validateAnswer(username, request));
	}
	
	@PutMapping("/:username/forgot")
	public ResponseEntity<?> updatePassword(@Valid @PathVariable("username") String username, @RequestBody UpdatePasswordRequest request){
		return ResponseEntity.status(200).body(customerService.updatePassword(username, request));
	}

}

