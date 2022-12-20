package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.FoodCategory;

public interface FoodCService {
	public List<FoodCategory> findAll1();
	public void save(FoodCategory food);
	public void deletebyId1(int id);
	public List<FoodCategory> findByfcname(String name);
	
	
}
