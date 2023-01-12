package com.htc.Kia.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.Kia.model.Product;

public class ExcelReader {

	public Product kiaTest() {

		Product productData = new Product();

//		int colIndex=0;
		FileInputStream file = null;
		String path = "kiaTest.xlsx";
		File xlsxFile = new File(path);
		// XSSFWorkbook book=null;
		XSSFWorkbook book = null;
		try {
			file = new FileInputStream(xlsxFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (path.endsWith("xls")) {

		} else if (path.endsWith("xlsx")) {
			try {
				book = new XSSFWorkbook(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		XSSFSheet sheet = book.getSheet("Sheet1");

		for (Row row : sheet) {

			int productId = Integer.parseInt(row.getCell(0).getStringCellValue());
			String productName = row.getCell(1).getStringCellValue();
			String productCategory = row.getCell(2).getStringCellValue();
			String productType = row.getCell(3).getStringCellValue();
			float productLength = (float) row.getCell(4).getNumericCellValue();
			float productDia = (float) row.getCell(5).getNumericCellValue();
			float productDrive = (float) row.getCell(6).getNumericCellValue();
			int productQuantity = (int) row.getCell(7).getNumericCellValue();
			float productVolume = (float) row.getCell(8).getNumericCellValue();
			String productFile = row.getCell(9).getStringCellValue();
			String productDesc = row.getCell(10).getStringCellValue();
			String productImage = row.getCell(11).getStringCellValue();

			productData.setProductId(productId);
			productData.setProductName(productName);
			productData.setProductCategory(productCategory);
			productData.setProductType(productType);
			productData.setProductLength(productLength);
			productData.setProductDia(productDia);
			productData.setProductDrive(productDrive);
			productData.setProductQuantity(productQuantity);
			productData.setProductVolume(productVolume);
			productData.setProductFile(productFile);
			productData.setProductDesc(productDesc);
			productData.setProductImage(productImage);

//			colIndex++;
		}
		try {
			file.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(productData);
		return productData;

	}

}
