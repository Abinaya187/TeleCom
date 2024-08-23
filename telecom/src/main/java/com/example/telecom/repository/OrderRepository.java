package com.example.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.telecom.entity.CustomerOrder;
import com.example.telecom.entity.Orders;


@Repository 
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	

}
