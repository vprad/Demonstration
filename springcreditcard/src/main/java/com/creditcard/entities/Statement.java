package com.creditcard.entities;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "Statement")
public class Statement {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long statementId;
		private double dueAmount;
		private LocalDate billingDate;
		private LocalDate dueDate;
		
		
		@ManyToOne
		@JoinColumn(name= "userId")
		private Customer customer;
	}

