package com.hcl.ing.retialbank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.retialbank.app.dto.AccountSummaryResponse;
import com.hcl.ing.retialbank.app.dto.AccountUpdateRequest;
import com.hcl.ing.retialbank.app.dto.AccountUpdateResponse;
import com.hcl.ing.retialbank.app.dto.SearchRequest;
import com.hcl.ing.retialbank.app.service.AccountServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@PostMapping("/searchbyaccnoaccname")
	public AccountSummaryResponse searchByAccountNoOrAccountName(@RequestBody SearchRequest request) {
		return accountServiceImpl.searchByAccountNoOrAccountName(request);
	}
	
	@PostMapping("/updateaccount")
	public AccountUpdateResponse updateAccountDetails(@RequestBody AccountUpdateRequest request) {
		return accountServiceImpl.updateAccountDetails(request);
	}
	

}
