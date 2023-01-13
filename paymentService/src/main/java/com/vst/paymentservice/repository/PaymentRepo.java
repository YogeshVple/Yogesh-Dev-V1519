package com.vst.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.paymentservice.model.Payment;

public interface PaymentRepo extends MongoRepository<Payment, Integer> {

}
