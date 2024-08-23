package com.example.telecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import com.example.telecom.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	
	public List<Products> findByproductName(String productName);

}
