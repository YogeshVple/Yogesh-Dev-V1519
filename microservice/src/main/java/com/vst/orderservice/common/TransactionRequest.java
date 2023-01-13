package com.vst.orderservice.common;

import com.vst.orderservice.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
	
	private Order order;
	private Payment payment;
	

}
