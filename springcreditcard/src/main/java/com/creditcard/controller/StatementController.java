package com.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entities.Statement;
import com.creditcard.exception.InvalidCardException;
import com.creditcard.service.StatementService;



@RestController

public class StatementController {

	@Autowired
	StatementService statementservice;
	
	@GetMapping("/list")
	public List<Statement> getAllStatements() {
		return statementservice.getAllStatements();
		
	}
	@GetMapping("/getstatement/{id}")
	public Statement  getStatement(@PathVariable("id") long id) {
		if(statementservice.getStatement(id)==null) {
			System.out.println("Statement Not Found !");
			throw new InvalidCardException();
		}
		return statementservice.getStatement(id);
	}
	
	@PostMapping(value="/addstatement",consumes = "application/json")
	public Statement addStatement(@RequestBody Statement statement) {
		
		return statementservice.addStatement(statement);
		
	}
	
	@DeleteMapping("/statement/delete/{id}")
	public  String removeStatement(long id) {
	//	return statementservice.removeStatement(id);
		if(statementservice.getStatement(id)==null) {
			System.out.println("Statement Not Found !");
			throw new InvalidCardException();
		}
		statementservice.removeStatement(id);
		return "Deleted successfully";
		
	}
	
	@PutMapping(value="/statement/update/{statementid}",consumes = "application/json")
	public Statement updateStatement(@PathVariable("statementid") long id,@RequestBody Statement statement) {
		if(statementservice.getStatement(id)==null) {
			System.out.println("Statement Not Found !");
			throw new InvalidCardException();
		}
		return statementservice.updateStatement(id, statement);
		
	}

}
