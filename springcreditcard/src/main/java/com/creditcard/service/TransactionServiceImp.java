package com.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.creditcard.entities.Customer;
import com.creditcard.entities.Transaction;
import com.creditcard.dao.ICustomerRepository;
import com.creditcard.dao.ITransactionRepository;
import java.util.Optional;
import lombok.Data;

@Service
public class TransactionServiceImp implements TransactionService{
	
	
	@Autowired
    private ITransactionRepository tr;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return tr.save(transaction);
	}

	@Override
	public Transaction removeTransaction(long id) {
		tr.deleteById(id);
		return tr.findByTranId(id);
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
		Transaction t = tr.findByTranId(id);
		t.setTranId(transaction.getTranId());
		t.setCardNumber(transaction.getCardNumber());
		t.setTranDate(transaction.getTranDate());
		t.setStatus(transaction.getStatus());
		t.setAmount(transaction.getAmount());
		t.setPaymentMethod(transaction.getPaymentMethod());
		t.setDescription(transaction.getDescription());
		t.setCustomer(transaction.getCustomer());
		return tr.save(t);
		
	}

	@Override
	public Transaction getTransactionDetails(long id) {
		return tr.findByTranId(id);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return tr.findAll();
	}
	

}