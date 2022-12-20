package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodServiceImp;
@RestController
@RequestMapping("/display")
public class FoodController {
private FoodServiceImp fsi;
@Autowired
public FoodController(FoodServiceImp fsi) {
	this.fsi = fsi;
}
@GetMapping("/food")
public List<Food> showAll(){
	return fsi.findAll();
	
}
@PostMapping("/addfood")
public Food addFood(@RequestBody Food fobj)
{
	fobj.setFid(0);
	fsi.save(fobj);
	return fobj;
}

@PutMapping("/updatefood")
public Food updateFood(@RequestBody Food fobj)
{
	fsi.save(fobj);
	return fobj;
}

@DeleteMapping("/deletefood/{id}")
public List<Food> deleteFood(@PathVariable int id)
{
	fsi.deletebyId(id);
	return fsi.findAll();
}
@GetMapping("/search/name")
public ResponseEntity<List<Food>> getFoodByFname(@RequestParam String name){
 return new ResponseEntity<List<Food>>(fsi.findByFname(name),HttpStatus.ACCEPTED);
}


}
