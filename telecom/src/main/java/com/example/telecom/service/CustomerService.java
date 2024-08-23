package com.example.telecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.telecom.entity.Customer;
import com.example.telecom.exception.CustomerNotFoundException;
import com.example.telecom.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public ResponseEntity<String> saveCustomer(Customer customer) {
		
		Customer newCustomer = new Customer();
		
		newCustomer.setCustomerName(customer.getCustomerName());
		newCustomer.setLocation(customer.getLocation());
		newCustomer.setContact(customer.getContact());
		
		customerRepository.save(customer);
		
		return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
			
	}
	
	
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<String> updateCustomer(Customer customer) {
		Optional<Customer> opCus = customerRepository.findById(customer.getCustomerId());

		if(opCus.isEmpty())
			throw new CustomerNotFoundException("Customer is not exists with the given id "+customer.getCustomerId());
		customerRepository.save(customer);
		
		return new ResponseEntity<>("updated successfully", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteCustomer(int customerId) {
		Optional<Customer> opDoc = customerRepository.findById(customerId);
		if(opDoc.isEmpty())
			throw new CustomerNotFoundException("Customer is not exists with the given id "+customerId);
		customerRepository.deleteById(customerId);
		
		return new ResponseEntity<>("Deleted Successsfully", HttpStatus.OK);
	}

	
	
}
