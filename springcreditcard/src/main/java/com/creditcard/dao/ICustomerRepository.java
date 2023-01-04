package com.creditcard.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditcard.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, String>{

	
	List <Customer>  findByAddressPincode(int pincode);
    public Customer findByUserId(String userId);

}