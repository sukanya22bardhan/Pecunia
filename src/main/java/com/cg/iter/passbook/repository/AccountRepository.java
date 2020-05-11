package com.cg.iter.passbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.passbook.dto.Account;



public interface AccountRepository extends JpaRepository<Account, String> {

	List<Account> findByAccountIdLikeOrderByAccountIdDesc(String string);
}
