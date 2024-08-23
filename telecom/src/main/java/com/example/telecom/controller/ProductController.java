package com.example.telecom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.entity.Orders;
import com.example.telecom.entity.Products;
import com.example.telecom.service.OrderService;
import com.example.telecom.service.ProductService;

@RestController
@RequestMapping("/Products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addProducts(@RequestBody Products product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Products>> getProducts(){
		return productService.getAllProducts();
	}
	
	
	
	@GetMapping("/name/{productName}")
	public ResponseEntity<Optional<Products>> getProductByName(@PathVariable("productName") String productName){
		return productService.getByName(productName);
	}

}
