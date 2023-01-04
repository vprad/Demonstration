package com.creditcard.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
	
	
		
		@ExceptionHandler(value = AccountNotFoundException.class)
		public ResponseEntity<Object> exception(AccountNotFoundException exception) {

		   return new ResponseEntity<Object>(" Account Not Found !", HttpStatus.NOT_FOUND);

		  }
		
		@ExceptionHandler(value = InvalidCardException.class)
		 public ResponseEntity<Object> exception(InvalidCardException exception) {

			   return new ResponseEntity<>("Sorry! Requested Not Found!", HttpStatus.NOT_FOUND);

			  }
		 
		 @ExceptionHandler(value = InvalidTransactionException.class)
		 public ResponseEntity<Object> exception(InvalidTransactionException exception) {

			   return new ResponseEntity<>("Transaction not found !", HttpStatus.NOT_FOUND);

			  }
		 

			
}



