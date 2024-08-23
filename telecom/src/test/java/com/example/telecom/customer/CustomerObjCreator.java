package com.example.telecom.customer;

import com.example.telecom.entity.Customer;

public class CustomerObjCreator {

	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setContact("7897654334");
		customer.setCustomerName("abinaya");
		customer.setLocation("bangalore");
		return customer;
	}
}
