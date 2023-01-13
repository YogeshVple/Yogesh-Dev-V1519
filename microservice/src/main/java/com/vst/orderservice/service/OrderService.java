package com.vst.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.orderservice.model.Order;
import com.vst.orderservice.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	public Order saveOrder(Order order)
	{
		return orderRepo.save(order);
	}
}
