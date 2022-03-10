/**
 * 
 */
package com.learning.service;

import java.util.List;

import com.learning.entity.Beneficiary;
import com.learning.payload.request.ApproveAccountRequest;
import com.learning.payload.request.ApprovedBeneficiaryRequest;
import com.learning.payload.request.SetEnabledRequest;
import com.learning.payload.request.TransferRequestStaff;
import com.learning.payload.response.AccountApprovalSummary;
import com.learning.payload.response.AccountDetailsStaffResponse;
import com.learning.payload.response.ApproveAccountResponse;
import com.learning.payload.response.ApprovedBeneficiaryResponse;
import com.learning.payload.response.CustomerSummary;

/**
 * @author "Olusola Agboola"
 * @date Mar 9, 2022
 * @time 4:18:33 PM
 */
public interface StaffService {
	AccountDetailsStaffResponse getAccountDetails(Long accountNo);

	List<Beneficiary> getUnapprovedBeneficiaries();

	ApprovedBeneficiaryResponse approveBeneficiary(ApprovedBeneficiaryRequest request);

	List<AccountApprovalSummary> getUnapprovedAccounts();

	ApproveAccountResponse approveAccount(ApproveAccountRequest request);

	List<CustomerSummary> getCustomers();

	String setCustomerEnabled(SetEnabledRequest request);

	CustomerSummary getCustomer(Long customerId);

	String staffTransferFunds(TransferRequestStaff request);

}
