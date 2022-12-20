package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FoodCategory;
import com.example.demo.persistance.FoodCategoryJpa;
@Service
public class FoodCServiceImp implements FoodCService {
	private FoodCategoryJpa fcj;
@Autowired
	public FoodCServiceImp(FoodCategoryJpa fcj) {
		this.fcj = fcj;
	}

	@Override
	@Transactional
	public List<FoodCategory> findAll1() {
		// TODO Auto-generated method stub
		return fcj.findAll();
	}

	@Override
	@Transactional
	public void save(FoodCategory food) {
		// TODO Auto-generated method stub
		fcj.save(food);
		
	}

	@Override
	@Transactional
	public void deletebyId1(int id) {
		// TODO Auto-generated method stub
		fcj.deleteById(id);
	}

	@Transactional
	public List<FoodCategory> findByfcname(String name) {
		// TODO Auto-generated method stub
		List<FoodCategory> r=null;
		if(name!=null && name.trim().length()>0)
		{
		r=fcj.findByfcname(name);
		}
		else
		{
			r = findAll1();
		}
		return r;
	}


}
