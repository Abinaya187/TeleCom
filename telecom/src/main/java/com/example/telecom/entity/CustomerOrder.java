package com.example.telecom.entity;

import java.time.LocalDate;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class CustomerOrder {
	
	private Customer customer;
	private Integer orderId;
	private LocalDate orderedDate;
	private Long amount;
	private String status;
	
	@OneToMany
	@JoinColumn(name = "productId")
	private Products product;
	
	
	
	public CustomerOrder() {
		super();
	}

	public CustomerOrder(Customer customer, Integer orderId, LocalDate orderedDate, Long amount, String status,
			Products product) {
		super();
		this.customer = customer;
		this.orderId = orderId;
		this.orderedDate = orderedDate;
		this.amount = amount;
		this.status = status;
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomerId(Customer customer) {
		this.customer = customer;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	


}
