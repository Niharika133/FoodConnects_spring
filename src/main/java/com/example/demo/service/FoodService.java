package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Food;

public interface FoodService {
	public List<Food> findAll();
	public void save(Food food);
	public void deletebyId(int id);
	public List<Food> findByFname(String name);
	public Food findById(int fid);
}
