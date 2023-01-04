package com.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entities.Transaction;
import com.creditcard.exception.AccountNotFoundException;
import com.creditcard.exception.InvalidTransactionException;
import com.creditcard.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transervimp;
	
	@PostMapping(value="/addtransaction",consumes = "application/json")
	public String addTransaction(@RequestBody Transaction transaction ) {
		
		transervimp.addTransaction(transaction);
		return "added successfully";
	}
	
	@DeleteMapping("/transaction/delete/{id}")
	public String removeTransaction(@PathVariable("id") long id) {
		if(transervimp.getTransactionDetails(id)==null) {
			//System.out.println("Not Found !");
			throw new InvalidTransactionException();
		}
		transervimp.removeTransaction(id);
		return "Deleted successfully";
	}
	
	@PutMapping(value="/transaction/update/{id}",consumes = "application/json")
	public String  updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
		if(transervimp.getTransactionDetails(id)==null) {
			System.out.println("Tranasaction not yet completed !");
			throw new InvalidTransactionException();
		}
	    transervimp.updateTransaction(id, transaction);
		return "Updated successfully";
		
	}

	@GetMapping("/transaction/{id}")
	public Transaction  getTransactionDetails(@PathVariable("id") long id) {
		if(transervimp.getTransactionDetails(id)==null) {
			System.out.println("Tranasaction not yet completed !");
			throw new InvalidTransactionException();
		}
		return transervimp.getTransactionDetails(id);
	}
	
	@GetMapping("/alltransactions")
	public List<Transaction> getAllTransactions(){
		return transervimp.getAllTransactions();
	}

}