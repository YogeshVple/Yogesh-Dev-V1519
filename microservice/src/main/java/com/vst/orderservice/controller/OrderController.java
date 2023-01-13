package com.vst.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.orderservice.model.Order;
import com.vst.orderservice.service.OrderService;

@RestController
@RequestMapping
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public Order bookOrder(@RequestBody Order order)
	{
		return orderService.saveOrder(order);
	}
	
}
