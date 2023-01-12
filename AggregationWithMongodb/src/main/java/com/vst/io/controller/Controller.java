package com.vst.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vst.io.model.DisplayAggregationModel;
import com.vst.io.model.DisplayModel;
import com.vst.io.query.DisplayQuery;







public class Controller {

	
	@Autowired
	DisplayQuery dispQuery;

	@RequestMapping(method = RequestMethod.GET, value = "getYelpBusiness")
	public List<DisplayModel> getDisplayData(
			@RequestParam(value = "limit", required=false)Integer limit,
			@RequestParam(value = "skip", required=false)Integer skip,
			@RequestParam(value = "city", required=false)String city,
			@RequestParam(value="sort", required=false)String sort
			){

		if(limit == null)
			limit = 30;

		return dispQuery.getResults(limit, skip, city, sort) ;
	}

	@RequestMapping(method = RequestMethod.GET, value = "getYelpBusinessAnalysis")
	public List<DisplayAggregationModel> getAnalysisData(
			@RequestParam(value = "limit", required=false)Integer limit,
			@RequestParam(value = "skip", required=false)Long skip,
			@RequestParam(value = "city", required=false)String city,
			@RequestParam(value="sort", required=false)String sort
			){

		if(limit == null)
			limit = 10;

		return dispQuery.getAnalysisResults(limit, skip) ;
	}
}
