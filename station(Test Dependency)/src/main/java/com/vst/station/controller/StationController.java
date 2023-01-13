package com.vst.station.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vst.station.exception.StationException;
import com.vst.station.model.Station;
import com.vst.station.service.SequenceGeneratorService;
import com.vst.station.service.StationServiceImpl;

import jakarta.validation.Valid;

public class StationController {

	@Autowired
	StationServiceImpl sService;

	@Autowired
	SequenceGeneratorService sequenceService;

	// private static final Logger logger =
	// LogManager.getLogger(StationController.class);

	/*
	 * addStation Method accepts data (Sample Data) Note --> No Need to pass the Id
	 * it will take automatically by sequence Generator "stationName":
	 * "Electric Vehicle", "stationLocation": "Gultekadi", "stationAddress":
	 * "Sr. No. 463/A, opp. Golden Bakery, Salisbury Park, Gultekadi, Pune, Maharashtra 411037"
	 * , "stationOwnerName": "OPQ", "stationChargerType": "AC",
	 * "stationNumberOfChargers": "10", "stationAmenity": [ "Bathrooms",
	 * "A place to walk the dogs", "Coffee and WiFi", "drinking water",
	 * "Entertainment" ] }
	 */
	@PostMapping("station")
	public String addStation(@Valid @RequestBody Station station) // Add details of Station
	{
		station.setId(sequenceService.getSequenceNumber(Station.SEQUENCE_NAME));
		station.setActive(true);
		if (sService.saveStation(station))
			return "Station Details Save Succesfully";
		else
			return "Somthing Went Wrong Please Check all the Details";
	}

	@DeleteMapping("stationDelete")
	public String deleteStation(@RequestParam("id") int id) // Delete one Record of station
	{
		if (id > 0) { 									// It will check pass id is positive or not
			if (sService.deleteStation(id)) 			// if id is negative it throw an exception 
				return "Record Delete Successfully";	// if id is positive then call to the service  
			else
				throw new StationException("Data Not Found Found");
		} else
			return "Please Enter vaild Id";
	}

	@GetMapping("stationList")
	public List<Station> listAllStation() {
		List<Station> list = sService.getStation();
		if (!list.isEmpty())
			return list;
		else
			throw new StationException("Data not Found");
	}

	@PutMapping("stationUpdate")
	public String updateStation(@RequestParam("id") int id, @RequestBody Station station) {
		// Update station details by taking station id as parameter with update details
		// from user.
		if (id > 0) {
			if (sService.updateStation(id, station))
				return "Update Succesfully";
			else
				throw new StationException("Somthing Went Wrong Please Check all the Details");
		} else
			throw new StationException("Id is not Vaild ");
	}

	@GetMapping("station")
	public Station getStation(@RequestParam("id") Integer id) {
		if (id > 0) {
			Station s = sService.getStatiOnId(id); // get the station Details by station ID.
			if (s != null) {
				return s;
			} else
				throw new StationException("Station Doesn't Exist");
		} else
			throw new StationException("Please Enter Vaild ID");

	}

	@GetMapping("stationName")
	public List<Station> getByStationName(@RequestParam("stationName") String stationName) {

		List<Station> list = sService.findByStationName(stationName);
		if (!list.isEmpty())
			return list;
		else
			throw new StationException("No Data Found");
	}

	@GetMapping("stationByNumberOfChargers")
	public List<Station> getByStationChargers(@RequestParam("numberOfCharger") Integer numberOfCharger) {
		List<Station> list = sService.findByStationNumberOfChargers(numberOfCharger);
		if (!list.isEmpty())
			return list;
		else
			throw new StationException("No Data Found");
	}

	@GetMapping("stationCharger")
	public List<Station> getChargerType(@RequestParam("sCharger") String sCharger) {
		List<Station> list = sService.findByStationChargerType(sCharger);
		if (!list.isEmpty())
			return list;
		else
			throw new StationException("No Data found");
	}
}
