/**
 * 
 */
package com.learning.service;

import java.util.List;

import com.learning.entity.Customer;
import com.learning.payload.request.AddBeneficiaryRequest;
import com.learning.payload.request.ApproveAccountRequest;
import com.learning.payload.request.AuthenticateRequest;
import com.learning.payload.request.CreateAccountRequest;
import com.learning.payload.request.TransferRequest;
import com.learning.payload.request.UpdatePasswordRequest;
import com.learning.payload.response.AccountCreationResponse;
import com.learning.payload.response.AccountDetailsResponse;
import com.learning.payload.response.AccountSummaryResponse;
import com.learning.payload.response.ApproveAccountResponse;
import com.learning.payload.response.BeneficiarySummaryResponse;
import com.learning.payload.response.RegisterUserResponse;
import com.learning.payload.response.UpdateCustomerResponse;

/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 4:09:04 PM
 */
public interface CustomerService {
	public RegisterUserResponse registerCustomer();
	public String authenticate(AuthenticateRequest request);
	public AccountCreationResponse addAccount(long customerId, CreateAccountRequest request);
	public ApproveAccountResponse aproveAccount(long customerId, long accountNumber, ApproveAccountRequest request);
	public List<AccountSummaryResponse> getCustomerAccounts(long customerId);
	public UpdateCustomerResponse updateCustomer(long customerId, Customer customer);
	public AccountDetailsResponse getCustomerAccount(long customerId, long accountId);
	public String addBeneficiary(long customerId, AddBeneficiaryRequest request);
	public List<BeneficiarySummaryResponse> getBeneficiaries(long customerId);
	public String deleteBeneficiary(long customerId, long beneficiaryId);
	public String transferFunds(TransferRequest request);
	public String getQuestions(String username);
	public String validateAnswer(String username, String answer);
	public String updatePassword(String username, UpdatePasswordRequest request);
	
}