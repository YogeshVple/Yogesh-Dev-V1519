package com.vst.station.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(collection = "stationDetails")
public class Station {

	@Id
	private int id;
	private String stationName;
	private String stationLocation;
	private String stationAddress;
	private String stationOwnerName;
	private String stationChargerType;
	private String stationNumberOfChargers;
	private ArrayList<String> stationAmenity;
	private boolean isActive = true;

}
