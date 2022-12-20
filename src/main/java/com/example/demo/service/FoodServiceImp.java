package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Food;
import com.example.demo.entity.Orders;
import com.example.demo.persistance.FoodJpa;
@Service
public class FoodServiceImp implements FoodService{
private FoodJpa obj;

@Autowired
	public FoodServiceImp(FoodJpa obj) {
	this.obj = obj;
}

	@Override
	@Transactional
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return obj.findAll();
	}

	@Override
	@Transactional
	public void save(Food food) {
		// TODO Auto-generated method stub
		obj.save(food);
	}

	@Override
	@Transactional
	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		obj.deleteById(id);
	}
	@Transactional
	public List<Food> findByFname(String name) {
		// TODO Auto-generated method stub
		List<Food> r=null;
		if(name!=null && name.trim().length()>0)
		{
		r=obj.findByFname(name);
		}
		else
		{
			r = findAll();
		}
		return r;
	}
	public Food findById(int fid) {
		// TODO Auto-generated method stub
		return obj.findById(fid).get();
	}

	
}
