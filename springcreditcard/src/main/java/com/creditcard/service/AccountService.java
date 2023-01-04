package com.creditcard.service;

import java.util.List;

import com.creditcard.entities.Account;
import com.google.common.base.Optional;


public interface AccountService {

	public Account addAccount(Account account);
	public Account removeAccount(long id);
	public Account updateAccount(long id, Account account);
	public Account getAccount(long id);
	public List<Account> getAllAccounts();
	



}
