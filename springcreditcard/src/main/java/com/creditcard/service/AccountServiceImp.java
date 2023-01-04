package com.creditcard.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.creditcard.dao.IAccountRepository;
import com.creditcard.entities.Account;


import lombok.Data;
@Data
@Service
public class AccountServiceImp implements AccountService {
	
	
	@Autowired
	IAccountRepository accountRepository;

	
	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	
	@Override
	public Account removeAccount(long id) {
		accountRepository.deleteById(id);
		return accountRepository.findByAccountId(id);
	}

	
	@Override
	
	public Account updateAccount(long id, Account account) {
		Account a= accountRepository.findByAccountId(id);
		a.setAccountName(account.getAccountName());
		a.setBalance(account.getBalance());
		a.setAccountType(account.getAccountType());
		return accountRepository.save(a);
	}

	@Override
	public Account getAccount(long id) {
		return accountRepository.findByAccountId(id);
	
	}

	@Override
	public List<Account> getAllAccounts() {		
	return accountRepository.findAll();
		
		
	}

}
