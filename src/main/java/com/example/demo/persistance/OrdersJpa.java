package com.example.demo.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Orders;

public interface OrdersJpa extends JpaRepository<Orders, Integer>  {
	
}
