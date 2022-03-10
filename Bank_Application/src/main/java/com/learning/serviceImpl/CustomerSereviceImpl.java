/**
 * 
 */
package com.learning.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.Customer;
import com.learning.entity.Transaction;
import com.learning.enums.EnabledStatus;
import com.learning.enums.IsActive;
import com.learning.exception.AccountCreationException;
import com.learning.exception.NoDataFoundException;
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
import com.learning.repo.AccountRepository;
import com.learning.repo.CustomerRepository;
import com.learning.service.CustomerService;


/**
 * @author "Olusola Agboola"
 * @date Feb 26, 2022
 * @time 6:24:01 PM
 */
@Service
public class CustomerSereviceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public RegisterUserResponse registerCustomer(RegisterRequest request) {
		Customer customer = new Customer();
		customer.setFullName(request.getFullName());
		customer.setUsername(request.getUsername());
		customer.setPassword(request.getPassword());
		customer.setCreatedDate(LocalDate.now());
		
		Customer newCustomer = customerRepo.save(customer);
		
		//create response from database
		RegisterUserResponse response = new RegisterUserResponse();
		response.setFullName(newCustomer.getFullName());
		response.setId(newCustomer.getUserId());
		response.setUserName(newCustomer.getUsername());
		response.setPassword(newCustomer.getPassword());
		
		return response;	
	}

	@Override
	public String authenticate(AuthenticateRequest request) {
		Customer customer = customerRepo.findByUsername(request.getUserName()).orElseThrow(()-> new NoDataFoundException("User not found"));
		return "JWT TOKEN HERE";
	}

	@Override
	public AccountCreationResponse addAccount(long customerID, CreateAccountRequest request) {
		Account newAccount = new Account();
		//Retrieve customer based on URL
		Customer currentCustomer = customerRepo.findById(customerID).orElseThrow(()->new NoDataFoundException("Customer Not Found"));

		//Store list of customer's current accounts, so we can tell which one is new, later.
		Set<Account> oldAccounts = currentCustomer.getAccounts();
		//Set all attributes of new account, based on defaults, and on request.
		newAccount.setAccountBalance(request.getAccountBalance());
		newAccount.setAccountType(request.getAccountType());
		newAccount.setApproved(request.getApproved());
		newAccount.setAccountStatus(EnabledStatus.ENABLED);
		newAccount.setCustomer(currentCustomer);
		newAccount.setDateOfCreation(LocalDate.now());
		newAccount.setTransaction(new ArrayList<Transaction>());
		//Add created account to customer.
		currentCustomer.getAccounts().add(newAccount);
		//Save customer to update list of accounts.  The returned Customer should have the
		//newly created Account, with its generated Account Number.
		Customer updatedCustomer = customerRepo.save(currentCustomer);
		Set<Account> newAccounts = updatedCustomer.getAccounts();
		//Compare the sets to find the newly created Account.
		newAccounts.removeAll(oldAccounts);
		if(newAccounts.isEmpty() || newAccounts.size() >1) {
			throw new AccountCreationException("Account Creation Failed");
		}
		Account createdAccount = ((Account[])newAccounts.toArray())[0];
		//Populate the response with the details of the new Account.
		AccountCreationResponse result = new AccountCreationResponse();
		result.setAccountType(createdAccount.getAccountType());
		result.setAccountBalance(createdAccount.getAccountBalance());
		result.setApproved(createdAccount.getApproved());
		result.setAccountNumber(createdAccount.getAccountNumber());
		result.setDateOfCreation(createdAccount.getDateOfCreation());
		result.setCustomerId(createdAccount.getCustomer().getUserId());

		return result;
	}

	@Override
	public ApproveAccountResponse approveAccount(long customerID, long accountNo, ApproveAccountRequest request) {
		// find the current customer
		Customer currentCustomer = customerRepo.findById(customerID).orElseThrow(()->new NoDataFoundException("Customer Not Found"));
		// get all the accounts
		Set<Account> accounts= currentCustomer.getAccounts();
		ApproveAccountResponse accountResponse = new ApproveAccountResponse();
		//for each loop to iterate the accounts
		for (Account account: accounts) {
			if(account.getAccountNumber() == accountNo) {
				account.setApproved(request.getApproved());
	
				// want the response to the user
				accountResponse.setAccountNumber(accountNo);
				accountResponse.setApproved(request.getApproved());
				
				customerRepo.save(currentCustomer);
				return accountResponse;
			} 
		}
		
		// if we couldn't find the account number, we will throw the exception 
		throw new NoDataFoundException("Please check Account Number");
		
	}

	@Override
	public List<AccountSummaryResponse> getCustomerAccounts(long customerId) {
		Customer currentCustomer = customerRepo.findById(customerId).orElseThrow(()->new NoDataFoundException("Customer Not Found"));
		//get all the accounts of the user
		Set<Account> accounts = currentCustomer.getAccounts();
		//create an empty list to hold the account for the response payload
		List<AccountSummaryResponse> responseList = new ArrayList<>();
		//iterate overs the accounts to get each account needed information
		for(Account account : accounts) {
			AccountSummaryResponse response = new AccountSummaryResponse();
			response.setAccountNumber(account.getAccountNumber());
			response.setAccountBalance(account.getAccountBalance());
			response.setAccountType(account.getAccountType());
			response.setEnabledStatus(account.getAccountStatus());
			responseList.add(response);	
		}
			
		return responseList;
	}
	
	@Override
	public GetCustomerResponse getCustomer(long customerId) {
		Customer currentCustomer = customerRepo.findById(customerId).orElseThrow(()->new NoDataFoundException("Customer Not Found"));
		GetCustomerResponse customer = new GetCustomerResponse();
		customer.setUserName(currentCustomer.getUsername());
		customer.setFullName(currentCustomer.getFullName());
		customer.setPan(currentCustomer.getPan());
		customer.setAadhar(currentCustomer.getAadhar());
		customer.setPhone(currentCustomer.getPhone());
		return customer;
	}

	@Override
	public UpdateCustomerResponse updateCustomer(long customerId, UpdateCustomerRequest customer) {
		Customer fromRepo = customerRepo.findById(customerId).orElseThrow(()->new NoDataFoundException("Customer ID Not Found"));
		//Check each field of the request to see if it contains an update.
		//and then apply the update to the retrieved customer

		if (customer.getAadhar() != null)
			fromRepo.setAadhar(customer.getAadhar());
		if (customer.getAadharImage() != null)
			fromRepo.setAadharImage(customer.getAadharImage());
		if (customer.getFullname() != null)
			fromRepo.setFullName(customer.getFullname());
		if (customer.getPan() != null)
			fromRepo.setPan(customer.getPan());
		if (customer.getPanImage() != null)
			fromRepo.setPanImage(customer.getPanImage());
		if (customer.getPhone() != null)
			fromRepo.setPhone(customer.getPhone());
		if (customer.getSecretQuestion() != null)
			fromRepo.setSecretQuestion(customer.getSecretQuestion());
		if (customer.getSecretAnswer() != null)
			fromRepo.setSecretAnswer(customer.getSecretAnswer());
		//Save the customer back to the database
		Customer updated = customerRepo.save(fromRepo);
		//Generate the response payload from the updated customer.
		UpdateCustomerResponse response = new UpdateCustomerResponse();
		response.setCustomerId(customerId);
		response.setFullName(updated.getFullName());
		response.setPhone(updated.getPhone());
		response.setPan(updated.getPan());
		response.setAadhar(updated.getAadhar());
		response.setSecretQuestion(updated.getSecretQuestion());
		response.setSecretAnswer(updated.getSecretAnswer());
		response.setPanImage(updated.getPanImage());
		response.setAadharImage(updated.getAadharImage());
		return response;
	}

	@Override
	public AccountDetailsResponse getCustomerAccount(long customerId, long accountId) {
		Customer currentCustomer = customerRepo.findById(customerId).orElseThrow(()->new NoDataFoundException("Customer Not Found"));
		Set<Account> accounts = currentCustomer.getAccounts();
		for(Account account : accounts) {
			if(account.getAccountNumber() == accountId) {
				AccountDetailsResponse accountDetailsResponse = new AccountDetailsResponse();
				accountDetailsResponse.setAccountNumber(account.getAccountNumber());
				accountDetailsResponse.setAccountBalance(account.getAccountBalance());
				accountDetailsResponse.setAccountType(account.getAccountType());
				accountDetailsResponse.setEnabledStatus(account.getAccountStatus());
				accountDetailsResponse.setTransaction(account.getTransaction());
				return accountDetailsResponse;
				
			}
		}
		throw new NoDataFoundException("Message: Sorry customer With " + accountId + "not found");
	}

	@Override
	public String addBeneficiary(long customerID, AddBeneficiaryRequest request) {
		//Retrieve the customer
		Customer customer = customerRepo.findById(customerID)
				.orElseThrow(()->new NoDataFoundException("Sorry Beneficiary With " + request.getAccountNumber() + " not added"));
		//Retrieve the set of beneficiaries
		Set<Beneficiary> beneficiaries = customer.getBeneficiaries();
		//Create a new beneficiary to add
		Beneficiary toBeAdded = new Beneficiary();
		toBeAdded.setAccountNo(request.getAccountNumber());
		toBeAdded.setAddedDate(LocalDate.now());
		toBeAdded.setAccountType(request.getAccountType());
		toBeAdded.setIsActive(IsActive.YES);
		toBeAdded.setApproved(request.getApproved());
		//add the beneficiary and save the customer to the repo.
		beneficiaries.add(toBeAdded);
		customerRepo.save(customer);
		return "Beneficiary with " + request.getAccountNumber() + " added";
	}

	@Override
	public List<BeneficiarySummary> getBeneficiaries(long customerId) {
		//Retrieve the customer
				Customer customer = customerRepo.findById(customerId)
						.orElseThrow(()->new NoDataFoundException("Customer ID not found"));
				//Retrieve the set of beneficiaries
				Set<Beneficiary> beneficiaries = customer.getBeneficiaries();
				List<BeneficiarySummary> summary = new ArrayList<>();
				
				for(Beneficiary beneficiary : beneficiaries) {
					BeneficiarySummary beneficiarySummary = new BeneficiarySummary();
					beneficiarySummary.setBeneficiaryAccountNumber(beneficiary.getAccountNo());
					beneficiarySummary.setBeneficiaryName(beneficiary.getName());
					beneficiarySummary.setActive(beneficiary.getIsActive());
					summary.add(beneficiarySummary);
				}
		return summary;
	}

	@Override
	public String deleteBeneficiary(long customerId, long beneficiaryId) {
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(()->new NoDataFoundException("Customer ID not found"));
		Set<Beneficiary> beneficiaries = customer.getBeneficiaries();
		//Beneficiary beneficiary = new Beneficiary();
		Iterator<Beneficiary> iterator = beneficiaries.iterator();
		while(iterator.hasNext()) {
			Beneficiary beneficiary = iterator.next();
			if(beneficiary.getBeneficiaryId()==beneficiaryId) {
				iterator.remove();
				customerRepo.save(customer);
				return "Beneficiary deleted successfully";
				
			}
			
		}
		return "Beneficiary not deleted";
	}


	@Override
	public String transferFunds(TransferRequest request) {
		Transaction transaction = new Transaction();
		//First, retrieve the appropriate accounts.
		Account fromAccount=accountRepo.findById(request.getFromAccountNumber())
				.orElseThrow(()-> new NoDataFoundException("From Account Not Valid"));
		transaction.setFromAccount(fromAccount);
		Account toAccount = accountRepo.findById(request.getToAccountNumber())
				.orElseThrow(()-> new NoDataFoundException("To Account Not Valid"));
		transaction.setToAccount(toAccount);
		//if we want to do validity checking, here would be good.  From Account should be 
		//part of request.customer's Account Set.  To Account should be part of Customer's 
		//beneficiary list.
		//next, input details about the transaction.
		transaction.setAmount(request.getAmount());
		transaction.setDate(LocalDateTime.now());
		transaction.setReference(request.getReason());
		//Add the transaction to the affected accounts.
		fromAccount.getTransaction().add(transaction);
		toAccount.getTransaction().add(transaction);
		//Temp variable stores balance and calculates new balance.
		double temp = fromAccount.getAccountBalance();
		//subtract amount from fromAccount's balance.
		temp-=transaction.getAmount();
		//Might check to ensure temp is still positive, throw NSF if not?
		fromAccount.setAccountBalance(temp);
	
		temp = toAccount.getAccountBalance();
		//Add amount to toAccount's balance.
		temp+=transaction.getAmount();
		toAccount.setAccountBalance(temp);
		//Save the affected accounts.
		accountRepo.save(fromAccount);
		accountRepo.save(toAccount);
		return "Transfer complete";
	}

	@Override
	public String getQuestion(String username) {
		//Get the customer
		Customer customer = customerRepo.findByUsername(username)
				.orElseThrow(() -> new NoDataFoundException("User not found"));
		//Return the customer's secret question.
		return customer.getSecretQuestion();
	}

	@Override
	public String validateAnswer(String username, SecretAnswerRequest request) {
		//Get the customer
		Customer customer = customerRepo.findByUsername(username)
				.orElseThrow(() -> new NoDataFoundException("User not found"));
		//compare the provided answer with the stored answer
		if(customer.getSecretAnswer().equalsIgnoreCase(request.getAnswer())) {
			//if they match, good.
			return "Details validated";
		}
		//if the don't match.
		return "Sorry your secret details are not matching";
	}

	// Preauthorize this one as customer?
		@Override
		public String updatePassword(String username, UpdatePasswordRequest request) {
			Customer customer = customerRepo.findByUsername(username)
					.orElseThrow(() -> new NoDataFoundException("Sorry password not updated"));
			customer.setPassword(request.getNewPassword());
			customerRepo.save(customer);
			return "new password updated";
		}
}
