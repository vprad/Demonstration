package com.creditcard.entities;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name= "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tranId;
	@Column
	private String cardNumber;
	@Column
	private LocalDate tranDate;
	@Column
	private String Status;
	@Column
	private double amount;
	@Column
	private String paymentMethod;
	@Column
	private String description;
	
	
	@ManyToOne
	
	@JoinColumn(name= "userId")
	private Customer customer;
}
