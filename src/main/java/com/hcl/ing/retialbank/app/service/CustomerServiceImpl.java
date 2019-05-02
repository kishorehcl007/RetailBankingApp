package com.hcl.ing.retialbank.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.retialbank.app.dto.CustomerResponse;
import com.hcl.ing.retialbank.app.entity.CustomerInfo;
import com.hcl.ing.retialbank.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerResponse loginUser(String username, String password) {
		CustomerResponse response = new CustomerResponse();

		List<CustomerInfo> customerLists = customerRepository.findAll();

		for (CustomerInfo customerInfo : customerLists) {

			if (customerInfo.getUserName().equals(username) && customerInfo.getPassword().equals(password)) {
				response.setResponse("Logined successfully");
			} else if (!customerInfo.getUserName().equals(username)) {
				response.setResponse("Unregistered user please register ..!");
			} else {
				response.setResponse("Username or password did not match");
			}

		}
		return response;
	}

	@Override
	public CustomerResponse changePassword(String userName, String password, Character customerAccess) {
		CustomerResponse response = null;
		try {
			response = new CustomerResponse();
			CustomerInfo cutomerInfo = customerRepository.findByUserName(userName);
			cutomerInfo.setPassword(password);
			cutomerInfo.setCustomerAccess(customerAccess);
			CustomerInfo petresponse = customerRepository.save(cutomerInfo);
			if (petresponse != null) {
				response.setResponse("Password changed successfully");
			}
		} catch (Exception e) {

		}
		return response;
	}

}
