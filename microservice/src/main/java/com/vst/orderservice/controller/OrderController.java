package com.vst.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.orderservice.model.Order;
import com.vst.orderservice.service.OrderService;
import com.vst.orderservice.service.SequenceGeneratorService;


@RestController
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SequenceGeneratorService sequenceService;
	
	@PostMapping("/bookOrder")
	public Order bookOrder(@RequestBody Order order)
	{
		order.setId(sequenceService.getSequenceNumber(Order.SEQUENCE_NAME));
		//order.setActive(true);
		return orderService.saveOrder(order);
	}
	
}
