package com.creditcard.service;

import java.util.List;


import com.creditcard.entities.CreditCard;

public interface CreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditCard);
	public CreditCard removeCreditCard(long cardId);
	public CreditCard updateCreditCard(long cardId, CreditCard card);
	public CreditCard getCreditCard(long cardId);
	public List<CreditCard> getAllCreditCards(); 

}