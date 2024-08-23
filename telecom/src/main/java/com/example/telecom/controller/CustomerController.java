package com.example.telecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telecom.entity.Customer;
import com.example.telecom.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getCustomer(){
		return customerService.getAllCustomers();
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyCustomerDetails(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable("id") int customerId) {
		 return customerService.deleteCustomer(customerId);
		
	}

}
