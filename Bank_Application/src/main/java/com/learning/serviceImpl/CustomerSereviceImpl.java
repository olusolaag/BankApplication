/**
 * 
 */
package com.learning.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Account;
import com.learning.entity.Customer;
import com.learning.exception.NoDataFoundException;
import com.learning.payload.request.AddBeneficiaryRequest;
import com.learning.payload.request.ApproveAccountRequest;
import com.learning.payload.request.AuthenticateRequest;
import com.learning.payload.request.CreateAccountRequest;
import com.learning.payload.request.RegisterRequest;
import com.learning.payload.request.TransferRequest;
import com.learning.payload.request.UpdatePasswordRequest;
import com.learning.payload.response.AccountCreationResponse;
import com.learning.payload.response.AccountDetailsResponse;
import com.learning.payload.response.AccountSummaryResponse;
import com.learning.payload.response.ApproveAccountResponse;
import com.learning.payload.response.BeneficiarySummaryResponse;
import com.learning.payload.response.RegisterUserResponse;
import com.learning.payload.response.UpdateCustomerResponse;
import com.learning.repo.CustomerRepository;
import com.learning.service.CustomerService;


/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 6:24:01 PM
 */
public class CustomerSereviceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public RegisterUserResponse registerCustomer(RegisterRequest request) {
		Customer customer = new Customer();
		customer.setFullName(request.getFullName());
		customer.setUsername(request.getUsername());
		customer.setPassword(request.getPassword());
		customer.setCreatedDate(LocalDate.now());
		
		Customer customer2 = customerRepository.save(customer);
		
		//create response from database
		RegisterUserResponse response = new RegisterUserResponse();
		response.setFullName(customer2.getFullName());
		response.setId(customer2.getUserId());
		response.setUserName(customer2.getUsername());
		response.setPassword(customer2.getPassword());
		
		return response;	
	}

	@Override
	public String authenticate(AuthenticateRequest request) {
		Customer customer = customerRepository.findByUsername(request.getUserName()).orElseThrow(()-> new NoDataFoundException("User not found"));
		return "JWT TOKEN HERE";
	}

	@Override
	public AccountCreationResponse addAccount(long customerId, CreateAccountRequest request) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new NoDataFoundException("user not found"));
		Set<Account> accounts = customer.getAccounts();
		Account newAccount = new Account();
		newAccount.setAccountBalance(request.getAccountBalance());
		newAccount.setAccountType(request.getAccountType());
		newAccount.setApproved(request.getApproved());
		newAccount.setDateOfCreation(LocalDate.now());
		accounts.add(newAccount);
		Customer updated = customerRepository.save(customer);
//		Set<Account> newAccounts = updated.getAccounts();
//		newAccounts.removeAll(accounts);
//		AccountCreationResponse response = new AccountCreationResponse();
//		response.setAccountBalance(newAccount.getAccountBalance());
		return null;
	}

	@Override
	public ApproveAccountResponse aproveAccount(long customerId, long accountNumber, ApproveAccountRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountSummaryResponse> getCustomerAccounts(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCustomerResponse updateCustomer(long customerId, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDetailsResponse getCustomerAccount(long customerId, long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addBeneficiary(long customerId, AddBeneficiaryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeneficiarySummaryResponse> getBeneficiaries(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBeneficiary(long customerId, long beneficiaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transferFunds(TransferRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuestions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateAnswer(String username, String answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePassword(String username, UpdatePasswordRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
