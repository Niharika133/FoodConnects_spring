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
import com.example.demo.entity.FoodCategory;
import com.example.demo.service.FoodCServiceImp;
@RestController
@RequestMapping("/display1")
public class FoodCController {

	private FoodCServiceImp fsi;
	@Autowired
	public FoodCController(FoodCServiceImp fsi) {
		this.fsi = fsi;
	}
	@GetMapping("/fc")
	public List<FoodCategory> showAll1(){
		return fsi.findAll1();	
	}
	@PostMapping("/addfc")
	public FoodCategory addFoodc(@RequestBody FoodCategory fcobj)
	{
		fcobj.setFcid(0);
		fsi.save(fcobj);
		return fcobj;
	}
	@PutMapping("/updatefc")
	public FoodCategory updateFoodc(@RequestBody FoodCategory fcobj)
	{
		fsi.save(fcobj);
		return fcobj;
	}
	@DeleteMapping("/deletefc/{id}")
	public List<FoodCategory> deleteFoodc(@PathVariable int id)
	{
		fsi.deletebyId1(id);
		return fsi.findAll1();
	}
//	@GetMapping("/search/{fcname}")
//	public List<FoodCategory>findByFcName(@RequestParam("fcname") String name)
//
//	{
//	List<FoodCategory> foodcat=fsi.findByfcname(name);
//       return foodcat;
//}
	
	@GetMapping("/search/name")
	public ResponseEntity<List<FoodCategory>> getFoodCategoryByFcname(@RequestParam String name){
     return new ResponseEntity<List<FoodCategory>>(fsi.findByfcname(name),HttpStatus.ACCEPTED);
}
}
