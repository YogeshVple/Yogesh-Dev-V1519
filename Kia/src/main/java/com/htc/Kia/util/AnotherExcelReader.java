package com.htc.Kia.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.Kia.model.Product;

public class AnotherExcelReader {

  public List < Product > kiaTestExcel() {

    List < Product > productList = new ArrayList < > ();

    Product productData = new Product();

    FileInputStream fis = null;
    try {
      fis = new FileInputStream("kiaTestList.xlsx");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    XSSFWorkbook workbook = null;
    try {
      workbook = new XSSFWorkbook(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
    Sheet sheet = workbook.getSheet("Sheet1");
    Iterator < Row > rows = sheet.iterator();
    rows.next();
    while (rows.hasNext()) {
      Row row = rows.next();
      Iterator < Cell > cells = row.cellIterator();
      while (cells.hasNext()) {
        Cell cell = cells.next();
        int productId = Integer.parseInt(cell.getStringCellValue());

        cell = cells.next();
        String productName = cell.getStringCellValue();

        cell = cells.next();
        String productCategory = cell.getStringCellValue();

        cell = cells.next();
        String productType = cell.getStringCellValue();

        cell = cells.next();
        float productLength = (float) cell.getNumericCellValue();

        cell = cells.next();
        float productDia = (float) cell.getNumericCellValue();

        cell = cells.next();
        float productDrive = (float) cell.getNumericCellValue();

        cell = cells.next();
        int productQuantity = (int) cell.getNumericCellValue();

        cell = cells.next();
        float productVolume = (float) cell.getNumericCellValue();

        cell = cells.next();
        String productFile = cell.getStringCellValue();

        cell = cells.next();
        String productDesc = cell.getStringCellValue();

        cell = cells.next();
        String productImage = cell.getStringCellValue();
        //
        //				productData.setProductId(productId);
        //				productData.setProductName(productName);
        //				productData.setProductCategory(productCategory);
        //				productData.setProductType(productType);
        //				productData.setProductLength(productLength);
        //				productData.setProductDia(productDia);
        //				productData.setProductDrive(productDrive);
        //				productData.setProductQuantity(productQuantity);
        //				productData.setProductVolume(productVolume);
        //				productData.setProductFile(productFile);
        //				productData.setProductDesc(productDesc);
        //				productData.setProductImage(productImage);

        productList.add(new Product(productId, productName, productCategory, productType, productLength, productDia, productDrive, productQuantity, productVolume, productFile, productDesc, productImage));

      }

    }

    return productList;
  }

}