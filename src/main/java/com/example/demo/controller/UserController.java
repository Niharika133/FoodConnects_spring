package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.entity.Food;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImp;
@RestController
@RequestMapping("/display")
public class UserController {
	private UserServiceImp usi;
	@Autowired
	public UserController(UserServiceImp usi) {
		this.usi = usi;
	}
	@GetMapping("/user")
	public List<User> showAll(){
		return usi.findAll();
	}
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User uobj)
	{
		uobj.setUid(0);
		usi.save(uobj);
		return uobj;
	}

}
