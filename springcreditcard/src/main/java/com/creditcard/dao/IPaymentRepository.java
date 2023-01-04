package com.creditcard.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.creditcard.entities.Payment;


public interface IPaymentRepository extends JpaRepository<Payment, Long> {
	Payment findByPaymentId(long id);
}
