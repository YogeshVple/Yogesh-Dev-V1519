//
//package com.vst.station.util;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.vst.station.model.Station;
//
//public class ExcelRReader {
//
//	@Autowired
//	Station stationData = new Station();
//
//	public List<Station> stationTest() {
//
//		List<Station> stationList = new ArrayList<>();
//
//		Station stationD = new Station();
//
//		FileInputStream ff = null;
//		try {
//			ff = new FileInputStream("D:\\Spring Projects\\station\\stationTestList.xlsx");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		XSSFWorkbook workbook = null;
//		try {
//			workbook = new XSSFWorkbook(ff);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		Sheet sheet = workbook.getSheet("Sheet1");
//
//		Iterator<Row> rows = sheet.iterator();
//
//		rows.next();
//
//		while (rows.hasNext()) {
//			Row row = rows.next();
//
//			Iterator<Cell> cells = row.cellIterator();
//			while (cells.hasNext()) {
//				Cell cell = cells.next();
//				String stationName = cell.getStringCellValue();
//				System.out.println(stationName);
//				cell = cells.next();
//				String stationLocation = cell.getStringCellValue();
//				System.out.println(stationLocation);
//				cell = cells.next();
//				String stationAddress = cell.getStringCellValue();
//				System.out.println(stationAddress);
//				cell = cells.next();
//				String stationOwnerName = cell.getStringCellValue();
//				System.out.println(stationOwnerName);
//				cell = cells.next();
//				String stationChargerType = cell.getStringCellValue();
//				System.out.println(stationChargerType);
//				cell = cells.next();
//				String stationNumberOfChargers = cell.getStringCellValue();
//				System.out.println(stationNumberOfChargers);
//
//				stationD.setStationName(stationName);
//				stationD.setStationLocation(stationLocation);
//				stationD.setStationAddress(stationAddress);
//				stationD.setStationOwnerName(stationOwnerName);
//				stationD.setStationChargerType(stationChargerType);
//				stationD.setStationNumberOfChargers(stationNumberOfChargers);
//				stationList.add(stationD);
//
//			}
//		}
//		return stationList;
//	}
//}