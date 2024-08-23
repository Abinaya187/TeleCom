package com.example.telecom.exception;


public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
