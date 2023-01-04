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
import com.creditcard.entities.CreditCard;
import com.creditcard.exception.AccountNotFoundException;
import com.creditcard.exception.InvalidCardException;
import com.creditcard.service.CreditCardService;


@RestController
public class CreditCardController {
	
	@Autowired
	CreditCardService credservimp;
	
	@PostMapping(value="/addcreditcard",consumes = "application/json")
	public CreditCard addCreditCard(@RequestBody CreditCard creditCard ) {
		
		
		return credservimp.addCreditCard(creditCard);
	}
	
//	@DeleteMapping("/creditcard/delete/{id}")
//	public CreditCard removeCreditCard(@PathVariable("id") long cardId) {
//		
//		return credservimp.removeCreditCard(cardId);
//	}
//	
	@DeleteMapping("/creditcard/delete/{id}")
	public String removeCreditCard(@PathVariable("id") long cardId) {
	if(credservimp.getCreditCard(cardId)==null) {
		System.out.println("credit card Not Found !");
		throw new InvalidCardException();
	}
	credservimp.removeCreditCard(cardId);
	return "Deleted successfully";
}
	
	
	@PutMapping(value="/creditcard/update/{cardId}",consumes = "application/json")
	public String updateCreditCard(@PathVariable("cardId") long cardId, @RequestBody CreditCard creditCard){
		if(credservimp.getCreditCard(cardId)==null) {
			System.out.println("credit card Not Found !");
			throw new InvalidCardException();
		}
		credservimp.updateCreditCard(cardId,creditCard);
		return "Updated Successfully";
	 
	}
	
	@GetMapping(value = "/get/{cardId}")
	public 	CreditCard getCreditCard(@PathVariable("cardId") long cardId) {
		
		if(credservimp.getCreditCard(cardId)==null) {
			System.out.println(" Invalid CardId !");
			throw new AccountNotFoundException();
		}
		return credservimp.getCreditCard(cardId);
		
	}
	
	
	@GetMapping(value= "/allcreditcards")
	public List<CreditCard> getAllCreditCards(){
		return credservimp.getAllCreditCards();
	}
	

}