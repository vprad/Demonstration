package com.creditcard.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.dao.IPaymentRepository;
import com.creditcard.entities.Payment;

@Service
public class IPaymentServiceImp implements IPaymentService {
	
	@Autowired
	private IPaymentRepository payrepo;

	@Override
	public Payment addPayment(Payment payment) {
		payrepo.save(payment);
		return payment;
	}

	@Override
	public Payment removePayment(long id) {
		Payment pay = getpayRec(id);
		if(pay != null)
		{
			payrepo.deleteById(id);
		}
		return pay;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		Payment pay = getpayRec(id);
		if(pay != null)
		{
			pay.setPaymentId(payment.getPaymentId());
			pay.setMethod(payment.getMethod());
			pay.setStatus(payment.getStatus());
			payrepo.save(pay);
		}
		return pay;
	}

	@Override
	public Payment getPaymentDetails(long id) {
		return payrepo.findByPaymentId(id);
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return payrepo.findAll();
		
	}
	
	public Payment getpayRec(long id) {
        Optional<Payment> payObj = payrepo.findById(id);
        if (payObj.isPresent()) {
        	System.out.println("present");
            return payObj.get();
            
        }
        return null;
    }

}