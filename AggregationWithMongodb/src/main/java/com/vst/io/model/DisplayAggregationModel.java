package com.vst.io.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(collection = "docs")
public class DisplayAggregationModel {

	
	@Field(value="city")
	private String city;
	private Integer noOfBusinesses;
	
	
}
