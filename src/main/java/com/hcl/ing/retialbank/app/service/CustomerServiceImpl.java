package com.hcl.ing.retialbank.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.AccountResponse;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.CustomerInfo;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{

	
	  @Autowired
	  AccountSummaryRepository accoutRespository;
	
	  @Autowired
	  CustomerRepository customerRepository; 
	  
	  @Autowired
	  TransactionRepository transationRepository;
	 
		
	  
	  
	@Override
	public UserResponse createAccount(CustomerDTO customerDto) {
		
		  Transaction transaction=new Transaction();	  
		  AccountSummary  createAcct=new AccountSummary();
		  CustomerInfo  customer=new CustomerInfo();
		  UserResponse  response=new UserResponse();
	
		 
		 createAcct.setAccountName(customerDto.getAccountName());
		 createAcct.setAccountType(customerDto.getAccountType());
		 createAcct.setAddress(customerDto.getAddress());
		 createAcct.setBranchName(customerDto.getBranchName());
		 createAcct.setClosingBalance(customerDto.getClosingBalance());
		 createAcct.setDob(customerDto.getDob());
		 createAcct.setRole(customerDto.getRole());
		 createAcct.setCreateDt(new Date());
		 
		 AccountSummary accountDetails= accoutRespository.save(createAcct);
		 
		   transaction.setAccountNumber(accountDetails.getAccountNo());
		   transaction.setClosingBalance(customerDto.getClosingBalance());
		   transaction.setTransactionAmount(customerDto.getClosingBalance());
		   transaction.setTransactionDate(new Date());
		   transaction.setTransactionRemarks("Opening Account");
		   transaction.setTransactionType("Crerdit");
		   transationRepository.save(transaction);
		 
		 
          customer.setAccno(accountDetails.getAccountNo());
		  customer.setCustomerAccess('F');
		  customer.setCustomerName(customerDto.getAccountName());
		  customer.setCustomerType(customerDto.getRole());
		  customer.setUserName(customerDto.getAccountName().concat("sder"));
		  customer.setPassword(customerDto.getBranchName().concat("5645324"));
		  customerRepository.save(customer);
		  
		 response.setPassword(customer.getPassword());
		 response.setUserName(customer.getUserName());
		
		
		return response ;
	}



	@Override
	public AccountResponse accountDetails(String userName) {
		
		  AccountResponse response=new AccountResponse();
		   Long accno=customerRepository.findByUserName(userName);
		   response.setAccNo(accno);	   
		  Double value= accoutRespository.findByClosingBalance(accno);
		  response.setBalance(value);   
		
		 return response ;
	

}
}
