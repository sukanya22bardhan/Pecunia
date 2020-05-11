package com.cg.iter.passbook.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.passbook.dto.Transaction;
import com.cg.iter.passbook.service.PassbookMaintenanceService;

@RestController
@RequestMapping("/passbook")
public class PassbookController {
	//localhost:8090/passbook/accountSummary
	@Autowired
	PassbookMaintenanceService passbookMaintenanceService;
	
	@GetMapping("/updatePassbook")
	List<Transaction> updatePassbook(@RequestParam String accountId){
		return passbookMaintenanceService.updatePassbook(accountId);
	}
	
	@GetMapping("/accountSummary")
	List<Transaction> accountSummary(@RequestParam String accountId,@RequestParam String startDate,@RequestParam String endDate){
		return passbookMaintenanceService.accountSummary(accountId, LocalDate.parse(startDate), LocalDate.parse(endDate));
	}
	

}
