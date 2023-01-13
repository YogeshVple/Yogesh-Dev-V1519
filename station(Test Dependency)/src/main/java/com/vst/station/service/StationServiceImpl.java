package com.vst.station.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.vst.station.exception.StationException;
import com.vst.station.model.Station;
import com.vst.station.repository.StationRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class StationServiceImpl implements StationInterface {
	
	@Autowired
	StationRepo stationRepo;

	@Override
	@Validated
	public boolean saveStation(@Valid @RequestBody Station station) {
		
				return true;
	}

	@Override
	@Transactional
	public boolean deleteStation(Integer id) {
		
			Station stationObj = stationRepo.findByIdAndIsActiveTrue(id);
			if(stationObj!=null)
			{ 
				stationObj.setActive(false);
				stationRepo.save(stationObj);
				return true;
			}
			else
			throw new StationException("Data not founnd");
		}

	@Override
	public List<Station> getStation() {
		return stationRepo.findAllByIsActiveTrue();
	}

	@Override
	@Transactional
	public Station getStatiOnId(Integer id) {
		return stationRepo.findByIdAndIsActiveTrue(id);

	}

	@Override
	@Transactional
	public boolean updateStation(Integer id, Station station) {
		Station obj = stationRepo.findById(id).get();
		if (station.getStationAddress() != null)
			obj.setStationAddress(station.getStationAddress());
		if (station.getStationChargerType() != null)
			obj.setStationChargerType(station.getStationChargerType());
		if (station.getStationAmenity() != null)
			obj.setStationAmenity(station.getStationAmenity());
		if (station.getStationLocation() != null)
			obj.setStationLocation(station.getStationLocation());
		if (station.getStationName() != null)
			obj.setStationName(station.getStationName());
		if (station.getStationNumberOfChargers() != null)
			obj.setStationNumberOfChargers(station.getStationNumberOfChargers());
		if (station.getStationOwnerName() != null)
			obj.setStationOwnerName(station.getStationOwnerName());
		stationRepo.save(obj);
		return true;
	}

	@Override
	public List<Station> findByStationName(String stationName) {
		return stationRepo.findByStationNameAndIsActiveTrue(stationName);
	}

	@Override
	public List<Station> findByStationNumberOfChargers(Integer numberOfCharger) {
		return stationRepo.findAllByStationNumberOfChargersAndIsActiveTrue(numberOfCharger);
	}

	@Override
	public List<Station> findByStationChargerType(String sCharger) {
		return stationRepo.findAllByStationChargerTypeAndIsActiveTrue(sCharger);
	}

}
