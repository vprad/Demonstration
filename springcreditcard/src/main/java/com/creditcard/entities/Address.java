package com.creditcard.entities;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;
	
}
