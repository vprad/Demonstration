package com.creditcard.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


import lombok.Data;

@Entity
@Data
@Table(name= "Payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long paymentId;
	private String method;
	private String status;
	
		
	
}
