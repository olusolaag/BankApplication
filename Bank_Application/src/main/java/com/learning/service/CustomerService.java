/**
 * 
 */
package com.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.entity.Customer;
import com.learning.payload.request.AddBeneficiaryRequest;
import com.learning.payload.request.ApproveAccountRequest;
import com.learning.payload.request.AuthenticateRequest;
import com.learning.payload.request.CreateAccountRequest;
import com.learning.payload.request.RegisterRequest;
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
import com.learning.payload.response.RegisterUserResponse;
import com.learning.payload.response.UpdateCustomerResponse;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 4:09:04 PM
 */
public interface CustomerService {
	public RegisterUserResponse registerCustomer(RegisterRequest request);
	public String authenticate(AuthenticateRequest request);
	public AccountCreationResponse addAccount(long customerId, CreateAccountRequest request);
	public ApproveAccountResponse approveAccount(long customerId, long accountNumber, ApproveAccountRequest request);
	public List<AccountSummaryResponse> getCustomerAccounts(long customerId);
	public UpdateCustomerResponse updateCustomer(long customerId, UpdateCustomerRequest customer);
	public AccountDetailsResponse getCustomerAccount(long customerId, long accountId);
	public String addBeneficiary(long customerId, AddBeneficiaryRequest request);
	public List<BeneficiarySummary> getBeneficiaries(long customerId);
	public String deleteBeneficiary(long customerId, long beneficiaryId);
	public String transferFunds(TransferRequest request);
	public String getQuestion(String username);
	public String validateAnswer(String username, SecretAnswerRequest request);
	public String updatePassword(String username, UpdatePasswordRequest request);
	public GetCustomerResponse getCustomer(long customerId);
	
}
