package com.example.demo.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FoodCategory;
public interface FoodCategoryJpa extends JpaRepository<FoodCategory, Integer>{
@Autowired
	public List<FoodCategory> findByfcname(String name);
}
