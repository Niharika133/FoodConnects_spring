package com.example.demo.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Food;

public interface FoodJpa extends JpaRepository<Food, Integer> {
	@Autowired
	public List<Food> findByFname(String name);
}
