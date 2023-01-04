package com.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.creditcard.entities.Statement;

@Repository
public interface IStatementRepository extends JpaRepository <Statement , Long>{

	Statement findByStatementId(long statementId);
}
