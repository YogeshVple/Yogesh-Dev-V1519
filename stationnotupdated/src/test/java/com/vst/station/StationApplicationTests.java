//package com.vst.station;
//
//
//import java.util.List;
//
//
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;  
//
//import com.vst.station.model.Station;
//import com.vst.station.service.StationServiceImpl;
//import com.vst.station.util.ExcelRReader;
////import com.vst.station.util.ExcelReader;
//
//@SpringBootTest
//class StationApplicationTests {
//	
//	@Autowired
//	StationServiceImpl stationService;
//
//	@Test
//	void classLoades()
//	{
//		ExcelRReader obj = new ExcelRReader();
//		
//		List<Station> station = obj.stationTest();
//		//System.out.println(station);
//		for (int i = 0; i < station.size(); i++) {
//			Assertions.assertEquals(true, stationService.saveStation(station.get(i)));
//				}
//	}
//}
////	@Test
////	void classLoader()
////	{
////		ExcelReader obj= new ExcelReader();
////		
////		Station station= obj.stationTest();
////		
////		Assertions.assertEquals(true, stationService.saveStation(station));
////	}
//	
//
//
//
