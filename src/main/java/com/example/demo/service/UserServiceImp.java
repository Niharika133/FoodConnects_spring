package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.persistance.UserJpa;
@Service
public class UserServiceImp implements UserService{
	private UserJpa uj;
	@Autowired
		public UserServiceImp(UserJpa uj) {
		this.uj = uj;
	}

		@Override
		@Transactional
		public List<User> findAll() {
			// TODO Auto-generated method stub
			return uj.findAll();
		}

		@Override
		public void save(User user) {
			// TODO Auto-generated method stub
			uj.save(user);
		}
		
		

}
