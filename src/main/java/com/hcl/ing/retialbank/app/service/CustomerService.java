package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.UserResponse;
import com.hcl.ing.retialbank.app.dto.AccountResponse;
import com.hcl.ing.retialbank.app.dto.CustomerDTO;

public interface CustomerService {
	
	
	public UserResponse createAccount(CustomerDTO customerDto);
	
	public AccountResponse accountDetails(String userName);

}
