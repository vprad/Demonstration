package com.creditcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.creditcard.entities.CreditCard;
import com.creditcard.entities.Customer;
import com.creditcard.dao.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	@Autowired
    private CreditCardRepository ccr;

	@Override
	public CreditCard addCreditCard(CreditCard creditCard) {
		return ccr.save(creditCard);
	}

	@Override
	public CreditCard removeCreditCard(long cardId) {
		ccr.deleteById(cardId);
		return ccr.findByCardId(cardId);
	}

	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard card) {
		CreditCard cc = ccr.findByCardId(cardId);
		cc.setCardName(card.getCardName());
		cc.setCardType(card.getCardType());
		cc.setCardNumber(card.getCardNumber());
		cc.setExpiryDate(card.getExpiryDate());
		cc.setBankName(card.getBankName());
		cc.setCustomer(card.getCustomer());
		return ccr.save(cc);
		
	}

	@Override
	public CreditCard getCreditCard(long cardId) {
		return ccr.findByCardId(cardId);
	}

	@Override
	public List<CreditCard> getAllCreditCards() {
		return ccr.findAll();
	}
	

}