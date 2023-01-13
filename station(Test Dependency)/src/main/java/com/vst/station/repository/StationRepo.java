package com.vst.station.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.vst.station.model.Station;

@EnableMongoRepositories
public interface StationRepo extends MongoRepository<Station, Integer>{
	
	
	List<Station> findAllByStationNameAndIsActive(String stationName);

	List<Station> findAllByStationNumberOfChargersAndIsActiveTrue(Integer numberOfCharger);

	public List<Station> findAllByStationChargerTypeAndIsActiveTrue(String sCharger);

	Station findByIdAndIsActiveTrue(Integer id);

	public List<Station> findByStationNameAndIsActiveTrue(String stationName);

	List<Station> findAllByIsActiveTrue();

}
