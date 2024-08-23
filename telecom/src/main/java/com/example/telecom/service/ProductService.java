package com.example.telecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.telecom.entity.CustomerOrder;
import com.example.telecom.entity.Orders;
import com.example.telecom.entity.Products;
import com.example.telecom.repository.OrderRepository;
import com.example.telecom.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	
	
	public ResponseEntity<String> saveProduct(Products product) {
		
		Products newproduct = new Products();
		newproduct.setProductName(product.getProductName());
		newproduct.setDescription(product.getDescription());
		
		productRepo.save(product);
		
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}
	

	public ResponseEntity<Optional<Products>> getByName(String productName) {
		return new ResponseEntity(productRepo.findByproductName(productName),HttpStatus.OK);
	}


	public ResponseEntity<List<Products>> getAllProducts() {
		return new ResponseEntity<>(productRepo.findAll(),HttpStatus.OK);	
		}
}
