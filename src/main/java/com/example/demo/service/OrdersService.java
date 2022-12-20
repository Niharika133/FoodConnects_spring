package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Food;
import com.example.demo.entity.Orders;

public interface OrdersService{
			public List<Orders> findAll();
			 public void save(Orders order);
		     public Orders findById(int uid);
		     public List<Food> getCartItems(int uid);
		     public void deletebyId(int oid);
                 
			}


