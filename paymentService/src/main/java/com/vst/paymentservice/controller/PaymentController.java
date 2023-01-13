package com.vst.paymentservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.paymentservice.model.Payment;
import com.vst.paymentservice.service.PaymentService;
import com.vst.paymentservice.service.SequenceGeneratorService;



@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private SequenceGeneratorService sequenceService;
	
	@PostMapping("/paymentAdd")
	public Payment savePayment(@RequestBody Payment payment) {
	payment.setPaymentId(sequenceService.getSequenceNumber(Payment.SEQUENCE_NAME));
	//payment.setActive(true);
	return paymentService.doPayment(payment);
	}
	

}
