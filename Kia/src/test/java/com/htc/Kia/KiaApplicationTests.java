package com.htc.Kia;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.htc.Kia.model.Product;
import com.htc.Kia.service.ProductService;
import com.htc.Kia.util.AnotherExcelReader;

@SpringBootTest
class KiaApplicationTests {

	@Autowired
	 ProductService productService;

	@Test
	void contextLoads() {

		AnotherExcelReader obj = new AnotherExcelReader();
		List<Product> product = obj.kiaTestExcel();
		System.out.println(product);
		for (int i = 0; i < product.size(); i++) {
			Assertions.assertEquals(true, productService.addProduct(product.get(i)));
		}
	}

//	@Test
//	void contextLoads() {	
//	
//		ExcelReader obj=new ExcelReader();
//		List<Product> product=obj.kiaTest();
//		
//	Assertions.assertEquals(true, productService.addProduct(product));
//	
//	}
//	@Test
//	void contextLoads() {	
//		
////		ExcelReader obj=new ExcelReader();
////		Product product=obj.kiaTest();
//	Assertions.assertEquals(true, productService.addProduct(new Product(1,"object","object","object",1.0f,1.0f,1.0f,1,1.0f,"object","object","object")));
//	}
}
