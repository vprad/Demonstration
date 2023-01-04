package com.creditcard.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.Transaction;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
	
	Transaction findByTranId(long tranId);

}