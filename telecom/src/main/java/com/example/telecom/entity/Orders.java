package com.example.telecom.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private LocalTime orderedTime;
	private String orderNo;
	private LocalDate orderedDate;
	private Long amount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Products product;
	
	

	public Orders() {
		super();
	}

	public Orders(Integer orderId, LocalTime orderedTime, String orderNo, LocalDate orderedDate, Long amount,
			String status, Customer customer, Products product) {
		super();
		this.orderId = orderId;
		this.orderedTime = orderedTime;
		this.orderNo = orderNo;
		this.orderedDate = orderedDate;
		this.amount = amount;
		this.status = status;
		this.customer = customer;
		this.product = product;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalTime getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(LocalTime orderedTime) {
		this.orderedTime = orderedTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	
	
	
}
	