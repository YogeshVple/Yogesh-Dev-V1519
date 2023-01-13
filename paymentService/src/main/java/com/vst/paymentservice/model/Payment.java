package com.vst.paymentservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment")

public class Payment {
	
	@Transient
	public static final String SEQUENCE_NAME = "payment_sequence";

	@Id
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	
}
