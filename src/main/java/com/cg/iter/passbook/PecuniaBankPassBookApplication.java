package com.cg.iter.passbook;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.iter.passbook.dto.Transaction;
import com.cg.iter.passbook.repository.TransactionRepository;

@SpringBootApplication
public class PecuniaBankPassBookApplication {

	@Autowired
	TransactionRepository tr;
	
	@PostConstruct
	public void initUsers() {
		LocalDate date = LocalDate.now();
		tr.save(new Transaction(123, "AC50", "savings",
				2000, "option1", date, 1234, "cash", "account name", 1000));
		tr.save(new Transaction(128, "AC50", "savings",
				400, "option1", LocalDate.parse("2020-05-09"), 1299, "cash", "account name", 200));
		tr.save(new Transaction(129, "AC50", "savings",
				20000, "option1", LocalDate.parse("2020-01-04"), 1284, "cash", "account name", 100));
		
		
		tr.save(new Transaction(124, "BC50", "current",
				3000, "option2", date, 1235, "cash", "account name", 1000));
		tr.save(new Transaction(125, "CC50", "savings",
				4000, "option3", date, 1236, "cash", "account name", 1000));
		tr.save(new Transaction(126, "DC50", "savings",
				5000, "option4", date, 1237, "cash", "account name", 1000));
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankPassBookApplication.class, args);
	}

}
