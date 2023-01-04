package com.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.dao.ICustomerRepository;
import com.creditcard.entities.Customer;

import java.util.List;


@Service
public class CustomerserviceImpl implements ICustomerService{

	

	    @Autowired
        ICustomerRepository customerRepository;
	    


	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Customer getCustomer(String userId) {
	        
	        return customerRepository.findByUserId(userId);
	    }


	    public Customer addCustomer(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    public Customer updateCustomer(String userId, Customer customer) {
	    	Customer c = customerRepository.findByUserId(userId);
	    	c.setName(customer.getName());
	    	c.setEmail(customer.getEmail());
	    	c.setContactNo(customer.getContactNo());
	    	c.setDob(customer.getDob());
	    	c.setAddress(customer.getAddress());
	    	return customerRepository.save(c);
	    }

	    public Customer removeCustomer(String userId) {
	    	customerRepository.deleteById(userId);
	    	return customerRepository.findByUserId(userId);
	    }

		@Override
		public List<Customer> getCustomersByLocation(int pincode) {

			return customerRepository.findByAddressPincode(pincode);
		}

	}

