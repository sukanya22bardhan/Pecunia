package com.cg.iter.passbook.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.iter.passbook.dto.Account;
import com.cg.iter.passbook.dto.Transaction;

public interface PassbookMaintenanceService {


	public List<Transaction> updatePassbook(String accountId);

	public List<Transaction> accountSummary(String accountId, LocalDate startDate, LocalDate endDate);
	
	public boolean accountValidation(Account account);
	
	public boolean updateLastUpdated (Account account);
		
}
