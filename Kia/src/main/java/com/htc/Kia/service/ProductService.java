package com.htc.Kia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.Kia.model.Product;
import com.htc.Kia.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public boolean addProduct(Product product) {
		if (productRepository.save(product) != null) {
			return true;
		}
		return false;
	}

	public Product getProduct(int productId) {
		Optional<Product> optProduct = productRepository.findById(productId);
		if (optProduct.isPresent()) {
			return optProduct.get();
		}
		return null;
	}

	public Product getProductByName(String productName) {
		return productRepository.findByProductName(productName);

	}

	public boolean updateProduct(int productId, Product product) {
		Optional<Product> optProduct = productRepository.findById(productId);
		if (optProduct.isPresent()) {

//			Product product = optProduct.get();
			productRepository.save(product);
			return true;
		}
		return false;

	}

	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public boolean deleteProduct(int productId) {
		Optional<Product> optproduct = productRepository.findById(productId);
		if (optproduct.isPresent()) {
			Product product = optproduct.get();
			productRepository.delete(product);
			return true;
		} else {
			return false;
		}
	}

}