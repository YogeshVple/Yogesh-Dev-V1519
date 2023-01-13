package com.vst.station.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
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

	@Transient
	public static final String SEQUENCE_NAME = "station_sequence";

	@Id
	private int id;
	@NotNull(message="Please Enter Vaild Data")
	private String stationName;
	@NotNull(message="Please Enter Vaild Data")
	private String stationLocation;
	@NotNull(message="Please Enter Vaild Data")
	private String stationAddress;
	@NotNull(message="Please Enter Vaild Data")
	private String stationOwnerName;
	@NotNull(message="Please Enter Vaild Data")
	private String stationChargerType;
	@NotNull(message="Please Enter Vaild Data")
	private String stationNumberOfChargers;
	private ArrayList<String> stationAmenity;
	private boolean isActive = true;
	
	
}
