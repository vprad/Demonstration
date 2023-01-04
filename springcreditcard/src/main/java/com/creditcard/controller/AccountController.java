package com.creditcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.creditcard.entities.Account;
import com.creditcard.exception.AccountNotFoundException;
import com.creditcard.service.AccountService;



import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/account")

public class AccountController {
	
		@Autowired
		AccountService accountserviceimp;
		
		
		@PostMapping(value="/addaccount",consumes = "application/json")
		public String addAccount(@RequestBody Account account ) {
			
			accountserviceimp.addAccount(account);
			return "added successfully";
		}
		
		@DeleteMapping("/account/delete/{id}")
		public String removeAccount(long id) {
			if(accountserviceimp.getAccount(id)==null) {
				System.out.println(" Account Not Found !");
				throw new AccountNotFoundException();
			}
			accountserviceimp.removeAccount(id);
			return "Deleted successfully";
		}
		
		@PutMapping(value="/account/update/{id}",consumes = "application/json")
		public String  updateAccount(@PathVariable("id") long id, @RequestBody Account account) {
			if(accountserviceimp.getAccount(id)==null) {
				System.out.println(" Account Not Found !");
				throw new AccountNotFoundException();
			}
			accountserviceimp.updateAccount(id, account);
			return "Updated successfully";
			
		}

		@GetMapping("/account/{id}")
		public Account getAccount(@PathVariable("id") long id) {
			if(accountserviceimp.getAccount(id)==null) {
				System.out.println(" Account Not Found !");
				throw new AccountNotFoundException();
			}
			return accountserviceimp.getAccount(id);
		
		}
		
		@GetMapping("/allaccounts")
		public List<Account> getAllAccounts(){
			return accountserviceimp.getAllAccounts();
		}
	}




