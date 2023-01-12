package com.htc.Kia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.htc.Kia.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	public Product findByProductName(String productName);
  

	
	
	
}


