package com.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.entities.Statement;
import com.creditcard.dao.IStatementRepository;
@Service
public class StatementServiceImp implements StatementService {

	
	@Autowired
	private IStatementRepository statementrepository;

	@Override
	public Statement addStatement(Statement statement) {
		return statementrepository.save(statement);
		
	}

	@Override
	public Statement removeStatement(long id) {
		statementrepository.deleteById(id);
		return statementrepository.findByStatementId(id);
		
	}

	@Override
	public Statement updateStatement(long id, Statement statement) {
		Statement s = statementrepository.findByStatementId(id);
		s.setDueAmount(statement.getDueAmount());
		s.setBillingDate(statement.getBillingDate());
		s.setDueDate(statement.getDueDate());
		s.setCustomer(statement.getCustomer());
		return statementrepository.save(s);

	}

	@Override
	public Statement getStatement(long id) {
		return statementrepository.findByStatementId(id);
	
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementrepository.findAll();
	}

	

}
