package com.cg.iter.passbook.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.passbook.dto.Account;
import com.cg.iter.passbook.dto.Transaction;
import com.cg.iter.passbook.repository.AccountRepository;
import com.cg.iter.passbook.repository.TransactionRepository;

@Service
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService
{
	@Autowired
    TransactionRepository transactionRepo;
	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Transaction> updatePassbook(String accountId) {
	
		List<Transaction> transList = new ArrayList<>();
		transList = transactionRepo.findById(accountId, LocalDateTime.now().plusMinutes(330));
		
		
		return transList;
	}

	@Override
	public List<Transaction> accountSummary(String accountId, LocalDate startDate, LocalDate endDate) {
		
		return transactionRepo.getAccountSummary(accountId, startDate, endDate);
	}

	@Override
	public boolean accountValidation(Account account) {
		
		return false;
	}

	@Override
	public boolean updateLastUpdated(Account account) {
		accountRepository.save(account);
		return true;
	}

	
}
