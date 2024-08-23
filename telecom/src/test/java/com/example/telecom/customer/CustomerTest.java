package com.example.telecom.customer;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.telecom.controller.CustomerController;
import com.example.telecom.service.CustomerService;

@ExtendWith(SpringExtension.class)
public class CustomerTest {

	@InjectMocks
	private CustomerController controller;
	
	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerObjCreator customerObj;
	
	@Test
	public void addCustomerTest() {
		Mockito.when(customerService.saveCustomer(Mockito.any())).thenReturn(new ResponseEntity<String>(HttpStatus.ACCEPTED));
		controller.addCustomer(customerObj.getCustomer());
	}
	
	@Test
	public void getCustomerTest() {
		controller.getCustomer();
	}
	
	@Test
	public void modifyCustomerDetailsTest() {
		Mockito.when(customerService.updateCustomer(Mockito.any())).thenReturn(new ResponseEntity<String>(HttpStatus.ACCEPTED));
		controller.modifyCustomerDetails(customerObj.getCustomer());
	}
	
	@Test
	public void removeCustomerTest() {
		Mockito.when(customerService.deleteCustomer(Mockito.anyInt())).thenReturn(new ResponseEntity<String>(HttpStatus.OK));
		controller.removeCustomer(2);
	}
}
