package com.example.telecom.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.telecom.entity.CustomerOrder;
import com.example.telecom.entity.Orders;
import com.example.telecom.exception.OrderNotFoundException;
import com.example.telecom.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public ResponseEntity<String> saveOrder(CustomerOrder order) {
		
		
		
		Orders newOrder = new Orders();
		newOrder.setAmount(order.getAmount());
		newOrder.setOrderedDate(LocalDate.now());
		newOrder.setOrderedTime(LocalTime.now());
		newOrder.setStatus(order.getStatus());
		newOrder.setProduct(order.getProduct());
		newOrder.setOrderNo(generateOrderNo());
		newOrder.setCustomer(order.getCustomer());
		
		orderRepo.save(newOrder);
		
		
		return new ResponseEntity<>("Order Saved Successfully!",HttpStatus.CREATED);
	}

	private String generateOrderNo() {
		String randomOrderNo = RandomStringUtils.randomAlphanumeric(6);
		return randomOrderNo;
	}

	public ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<>(orderRepo.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<String> updateOrder(Orders order) {
		Optional<Orders> opDoc = orderRepo.findById(order.getOrderId());

		if(opDoc.isEmpty())
			throw new OrderNotFoundException("Doctor is not exists with the given id "+order.getOrderId());
		orderRepo.save(order);
		
		return new ResponseEntity("Updated",HttpStatus.OK);
	}

	public ResponseEntity<String> deleteOrder(int orderId) {
		Optional<Orders> opDoc = orderRepo.findById(orderId);
		if(opDoc.isEmpty())
			throw new OrderNotFoundException("Order is not exists with the given id "+orderId);
		orderRepo.deleteById(orderId);
		
		return new ResponseEntity<>("Deleted!",HttpStatus.OK);
	}
	
}
