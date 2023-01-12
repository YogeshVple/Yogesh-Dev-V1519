package com.vst.io.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "docs")
public class DisplayModel {	
	
		@Id
		private String Id;
		private String name;
		private String city;
		private Double stars;
		private Integer reviewCount;
	
}
