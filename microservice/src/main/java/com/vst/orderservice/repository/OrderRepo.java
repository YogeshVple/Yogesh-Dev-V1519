package com.vst.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.orderservice.model.Order;

public interface OrderRepo extends MongoRepository<Order, Integer>{

}
