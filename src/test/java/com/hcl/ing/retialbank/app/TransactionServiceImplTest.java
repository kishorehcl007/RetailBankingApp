package com.hcl.ing.retialbank.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.retialbank.app.dto.TransactionResponse;
import com.hcl.ing.retialbank.app.entity.Transaction;
import com.hcl.ing.retialbank.app.pojo.TransactionPojo;
import com.hcl.ing.retialbank.app.repository.AccountSummaryRepository;
import com.hcl.ing.retialbank.app.repository.TransactionRepository;
import com.hcl.ing.retialbank.app.service.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest 
{
	@InjectMocks
	TransactionServiceImpl transactionService;
	@Mock
	AccountSummaryRepository accountSummaryRepository;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@Test
	public void transactionTest()
	{
		/*TransactionResponse response=new  TransactionResponse();
		response.setMessage("ammount debited successfully");
		TransactionPojo transactionPojo=new TransactionPojo();
		transactionPojo.setAccountNumber(1l);
		transactionPojo.setFromAccountNumber(2l);
		transactionPojo.setTransactionAmount(500.0);
		transactionPojo.setTransactionRemarks("first");
		transactionPojo.setTransactionType("debit");
		Transaction transaction=new Transaction();
		transaction.setAccountNumber(1l);
		transaction.setClosingBalance(500.0);
		transaction.setFromAccountNumber(2l);
		transaction.setTransactionAmount(200.0);
		transaction.setTransactionId(1l);
		transaction.setTransactionRemarks("first");
		transaction.setTransactionDate(new Date());
		transaction.setTransactionType("debit");
		when(transactionRepository.save(transaction)).thenReturn(transaction);
		assertEquals("amount debited successfully", transactionService.transaction(transactionPojo));*/
		
	}
}