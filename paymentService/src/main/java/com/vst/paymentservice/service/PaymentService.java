package com.vst.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.paymentservice.model.Payment;
import com.vst.paymentservice.repository.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	
	public String paymentProcessing() {
		 return new Random().nextBoolean()?"suceess": "false" ;

	}
}
