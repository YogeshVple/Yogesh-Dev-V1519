package com.vst.station.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.station.dto.StationDTO;
import com.vst.station.model.Station;

@Component
public class StationConverter {

	public Station dtoToEntity(StationDTO station) {

		Station object = new Station();
		BeanUtils.copyProperties(station, object);
		return object;
	}

	public StationDTO entityToDto(Station station) {

		StationDTO object = new StationDTO();
		BeanUtils.copyProperties(station, object);
		return object;
	}

}
