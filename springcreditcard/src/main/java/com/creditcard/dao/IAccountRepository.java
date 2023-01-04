package com.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.entities.Account;

@Repository
public interface IAccountRepository extends JpaRepository <Account , Long>{

	Account findByAccountId(long accountId);
}




