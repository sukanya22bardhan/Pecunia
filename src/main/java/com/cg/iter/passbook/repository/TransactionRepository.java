package com.cg.iter.passbook.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cg.iter.passbook.dto.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
	
	@Query("select t from Transaction t where t.accountId= ?1 AND t.transDate BETWEEN (SELECT lastUpdated from Account where accountId= ?1) and ?2")
	List<Transaction> findById(String accountId, LocalDateTime currentDate);

	@Query("select t from Transaction t where t.accountId= ?1 AND t.transDate BETWEEN ?2 and ?3")
	List<Transaction> getAccountSummary(String accountId, LocalDate startDate, LocalDate endDate);
	

}
