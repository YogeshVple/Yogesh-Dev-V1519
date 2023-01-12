package com.htc.Kia.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.Kia.exeption.TaskException;
import com.htc.Kia.model.Product;
import com.htc.Kia.service.ProductService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	 @GetMapping(value = "/index")
	    public String info() 
	 	{
		 	return " <h1 style=color:Blue; > Welcome to Kia Assembly Management System   </h1> ";
		 
	 	} //Handler method 
	
	@GetMapping(value = "/info")//after removing the method we can get the css styled o/p in browsers
		public String info(int id, String pass) //Handler method 
		{ 
			if(id==28359 && pass.equals("Pratik2001")) 
			{
			return " <h1 style=color:green; > Login Successfull <br>Welcome to Spring Boot Application User:  </h1> "+ id;
			}
			return " <h1 style=color:red; > Invalid User Id or Password : </h1> " + id;
		}
	
	//add product 
	
	
	@PostMapping(value="/addProduct", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		String response = "";
		if( productService.addProduct(product) ) {
			response =  "{'status': 'success'}";
		}
		else {
			throw new TaskException("Something went wrong", HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
		
		ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
		return respEntity;
	}
	
	
	@GetMapping(value="/getProduct/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
//	@CrossOrigin(origins="http://localhost:8080")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		Product product = productService.getProduct(productId);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
	//	headers.add("Access-Control-Allow-Origin", "*");
	//	headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	//	headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");

		if(product!=null) {
			ResponseEntity<Product> respEntity = new ResponseEntity<Product>(product, headers, HttpStatus.OK);
			return respEntity;
		}else {
			ResponseEntity<Product> respEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			return respEntity;
		}
	}
	
	@DeleteMapping(value="/deleteProduct/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteProduct(@PathVariable("productId")int productNo) {
		if( productService.deleteProduct(productNo)) {
			return "{'status': 'success'}";
		}
		else {
			//return "{'status': 'fail'}";
			throw new TaskException("Product details not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/updateProduct/{productId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@PathVariable("productId")int productId, @RequestBody Product product)
	{
//		Product product = songService.getProduct(productId);
		productService.updateProduct(productId,product);
		if( productService.updateProduct(productId,product)) {
			return "{'status': 'success'}";
		}
		else {
			throw new TaskException("Product details not found", HttpStatus.NOT_FOUND);
		}
		
	}
	
	  @GetMapping(value="/getAllProducts", produces=MediaType.APPLICATION_JSON_VALUE)
//	    @CrossOrigin(origins="http://localhost:8080")
	    public ResponseEntity<List<Product>> getAllProducts(){
	        List<Product> product = productService.getAllProducts();
	        return new ResponseEntity<>(product,HttpStatus.OK);
	    
	    }
	  
	  
	  @GetMapping(value="/getProductByName/{productName}", produces=MediaType.APPLICATION_JSON_VALUE)
//		@CrossOrigin(origins="http://localhost:8088")
		public ResponseEntity<Product> getProduct(@PathVariable("productName") String productName) {
		  Product product =  productService.getProductByName(productName);
		  
			 

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
		//	headers.add("Access-Control-Allow-Origin", "*");
		//	headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		//	headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");

			if(product!=null) {
				ResponseEntity<Product> respEntity = new ResponseEntity<Product>(product, headers, HttpStatus.OK);
				return respEntity;
			}else {
				ResponseEntity<Product> respEntity = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
				return respEntity;
			}
		}
	  
	  
	  
	
	
	
}