package com.creditcard.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditcard.entities.Payment;
import com.creditcard.exception.InvalidCardException;
import com.creditcard.service.IPaymentServiceImp;

@RestController
public class PaymentController {
	@Autowired
	IPaymentServiceImp payservice;
	
	@PostMapping(path= "/pay/add")
	public ResponseEntity<com.creditcard.entities.Payment> addNewpayment(@RequestBody Payment payment)
	{
		if(payment == null)
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(payservice.addPayment(payment), HttpStatus.OK);
		
	}
	@DeleteMapping(path= "/pay/del/{paymentId}")
	public ResponseEntity<Payment> deleteCarById(@PathVariable("paymentId") Long id)
	{
		
		return new ResponseEntity<>(payservice.removePayment(id), HttpStatus.OK);
	}
	@PutMapping(path="/pay/update/{paymentId}")
	public ResponseEntity<Payment> updateCarById(@PathVariable("paymentId") Long id, @RequestBody Payment payment)
	{
		
		return new ResponseEntity<>(payservice.updatePayment(id, payment), HttpStatus.OK);
	}
	
	
	@GetMapping(path="/allpayments")
	public ResponseEntity<List<Payment>> getAllPayments()
	{
		
		return new ResponseEntity<>(payservice.getAllPaymentDetails(), HttpStatus.OK);	
	}
	
	@GetMapping(path="/pay/getbyid/{paymentId}")
	public ResponseEntity<Payment> getCarById(@PathVariable("paymentId") Long id)
	{
		if(payservice.getPaymentDetails(id) == null)
		{
			throw new InvalidCardException();
		}
		return new ResponseEntity<>(payservice.getPaymentDetails(id), HttpStatus.OK);
	}
		
	

}