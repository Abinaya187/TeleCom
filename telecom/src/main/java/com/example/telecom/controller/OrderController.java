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

import com.example.telecom.entity.CustomerOrder;
import com.example.telecom.entity.Orders;
import com.example.telecom.service.OrderService;

@RestController
@RequestMapping("/Orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrders(@RequestBody CustomerOrder order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Orders>> getOrders(){
		return orderService.getAllOrders();
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyOrderDetails(@RequestBody Orders order) {
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable("id") int orderId) {
		 return orderService.deleteOrder(orderId);
	}

	
	
}
