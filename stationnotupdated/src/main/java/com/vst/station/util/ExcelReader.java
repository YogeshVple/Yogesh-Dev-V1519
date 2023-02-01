//package com.vst.station.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.List;
//
////import org.apache.poi.hssf.usermodel.HSSFWorkbook;
////import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.vst.station.model.Station;
//
//public class ExcelReader {
//
//	public Station stationTest() {
//	
//		Station stationData = new Station();
//
//		FileInputStream file = null;
//		String path = "D:\\Spring Projects\\station\\stationTestList.xlsx";
//		File xlsxFile = new File(path);
//
//		XSSFWorkbook bb = null;
//
//		try {
//			file = new FileInputStream(xlsxFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (path.endsWith("xls")) {
//			try {
//				bb = new XSSFWorkbook(file);
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//		} else if (path.endsWith("xlsx")) {
//			try {
//				bb = new XSSFWorkbook(file);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		XSSFSheet sheet = bb.getSheet("sheet1");
//
//		for (Row row : sheet) {
//
//			int id = (int) row.getCell(1).getNumericCellValue();
//
//			String stationName = row.getCell(2).getStringCellValue();
//			// System.out.println(stationName);
//
//			String stationLocation = row.getCell(3).getStringCellValue();
//			// System.out.println(stationLocation);
//
//			String stationAddress = row.getCell(4).getStringCellValue();
//			// System.out.println(stationAddress);
//
//			String stationOwnerName = row.getCell(5).getStringCellValue();
//			// System.out.println(stationOwnerName);
//
//			String stationChargerType = row.getCell(6).getStringCellValue();
//			// System.out.println(stationChargerType);
//
//			String stationNumberOfChargers = row.getCell(7).getStringCellValue();
//			// System.out.println(stationNumberOfChargers);
//
//			stationData.setStationName(stationName);
//			stationData.setStationLocation(stationLocation);
//			stationData.setStationAddress(stationAddress);
//			stationData.setStationOwnerName(stationOwnerName);
//			stationData.setStationChargerType(stationChargerType);
//			stationData.setStationNumberOfChargers(stationNumberOfChargers);
//
//		}
//		try {
//			file.close();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		// System.out.println(stationData);
//		return stationData;
//
//	}
//
//}
