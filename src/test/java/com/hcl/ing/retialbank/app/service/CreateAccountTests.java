package com.hcl.ing.retialbank.app.service;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.CustomerDTO;
import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.entity.AccountSummary;
import com.hcl.ing.retialbank.app.entity.CustomerInfo;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTests {
	
	
	@Mock
	AccountSummaryRepository accoutRespository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	
	
	//@Test
	public void testCreateAccount() {
		
		CustomerDTO customerDto=new CustomerDTO();
		AccountSummary accountInfo=new AccountSummary();
		
		
		accountInfo.setAccountNo(1234L);
		accountInfo.setAccountName("suma");
		
		
		CustomerInfo customerinfo=new CustomerInfo();
		customerinfo.setUserName("karnasder");
		customerinfo.setPassword("Ecbranch5645324");
		
		customerDto.setAccountName("karna");
		customerDto.setAccountType("savingsAcc");
		customerDto.setAddress("Bangalore");
		customerDto.setBranchName("Ecbranch");
		customerDto.setClosingBalance(20.0);
		customerDto.setDob("14-12-1990");
		customerDto.setRole("Admin");
		customerDto.setAccountNo(1234L);
		
		Mockito.when(accoutRespository.save(accountInfo)).thenReturn(accountInfo);
		Mockito.when(customerRepository.save(customerinfo)).thenReturn(customerinfo);;
		UserResponse response=customerService.createAccount(customerDto);
		
		Assert.assertEquals(customerinfo.getUserName(), response.getUserName());
	
		Assert.assertEquals(customerinfo.getPassword(), response.getPassword());
		
		
		
	}
	
	
	public void testAccountDetails() {
		   
	   /* AccountSummary account=new AccountSummary();
	    account.setAccountNo(1234L);
	    account.setClosingBalance(1234.0);
	
		Mockito.when(customerRepository.findByUserName("suma")).thenReturn(account);
		
		Mockito.when(accoutRespository.findByClosingBalance(1234L)).thenReturn(1234.0);;
		
		AccountResponse accresponse=customerService.accountDetails("suma");
		
	   Assert.assertEquals(account.getAccountNo(), accresponse.getAccNo());
		
	   Assert.assertEquals(account.getClosingBalance(), accresponse.getBalance());
		
	}*/

	
	}
	
	}
	
	
	
	
	


