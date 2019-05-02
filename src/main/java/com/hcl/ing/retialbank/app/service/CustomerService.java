package com.hcl.ing.retialbank.app.service;

import com.hcl.ing.retialbank.app.dto.CustomerResponse;

public interface CustomerService {

	public CustomerResponse loginUser(String username,String password);
	
	public CustomerResponse changePassword(String customerId,String password,Character customerAccess);
}
