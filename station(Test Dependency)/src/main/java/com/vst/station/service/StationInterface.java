package com.vst.station.service;

import java.util.List;

import com.vst.station.model.Station;

public interface StationInterface {
	
	public boolean saveStation(Station station);

	public boolean deleteStation(Integer id);

	public List<Station> getStation();

	public Station getStatiOnId(Integer id);

	public boolean updateStation(Integer id, Station station);

	public List<Station> findByStationName(String stationName);

	public List<Station> findByStationNumberOfChargers(Integer numberOfCharger);

	public List<Station> findByStationChargerType(String sCharger);


}
