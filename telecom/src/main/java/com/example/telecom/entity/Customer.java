package com.example.telecom.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName;
	private String location;
	private String contact; 
	
//	@OneToMany(mappedBy = "customer")
//	@JsonIgnore
//	private List<Orders> orders;
	
	@OneToMany
	private List<Products> product;
	
	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, String location, String contact, List<Orders> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.location = location;
		this.contact = contact;
//		this.orders = orders;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
	
	
	

}
