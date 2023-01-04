package com.creditcard.entities;
import java.time.LocalDate;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Data
@Table(name = "creditcards")
public class CreditCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cardId;
	@Column
	private String cardName;
	@Column
	private String cardType;
	@Column
	private String cardNumber;
	@Column
    private LocalDate expiryDate;
	@Column
	private String bankName;
    
	
	@ManyToOne
	@JoinColumn(name="userId" )
	private Customer customer;
	
	
	
}