package com.vst.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.redis.entity.Product;
import com.vst.redis.repository.ProductRepo;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class RedisApplication {

	@Autowired
	private ProductRepo productRepo;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@GetMapping
	public List<Product> getAllList() {
		return productRepo.findAll();
	}

	@GetMapping({ "/id" })
	public Product getProduct(@PathVariable int id) {
		return productRepo.findProdcutById(id);
	}

	@DeleteMapping({ "/id" })
	public boolean deletepro(@PathVariable int id) {
		productRepo.deleteById(id);
		return true;
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
