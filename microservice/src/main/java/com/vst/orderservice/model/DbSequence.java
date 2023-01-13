package com.vst.orderservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "order_db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DbSequence {
	
	@Id
	private String id;
	private int seq;

}
