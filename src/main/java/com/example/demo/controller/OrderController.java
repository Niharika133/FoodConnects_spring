package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Food;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersServiceImp;
@RestController
@RequestMapping("/order")
public class OrderController{
private OrdersServiceImp osi;
@Autowired
public OrderController(OrdersServiceImp osi) {
	this.osi = osi;
}
@GetMapping("/orders")
public List<Orders> showAll(){
	return osi.findAll();
}
@PostMapping("/addFoodItemToCart")
public List<Orders> addFoodItemTOCart(@RequestBody Orders order) {
	boolean found = osi.presentincart(order);
	if(!found) {
		System.out.println("Product being added is not is user cart");
		order.setOid(0);
		order.setQuantity1(1);
		osi.save(order);
	}
	return osi.findAll();
}




@PostMapping("/addorder")
public Orders addFoodo(@RequestBody Orders order)
{
	boolean found= osi.presentincart(order);
	if(!found) {
		order.setOid(0);
		order.setQuantity1(1);
		osi.save(order);
		
	}
	return order;
}
@GetMapping("/getuser/{uid}")
public List<Food> getCartItems(@PathVariable int uid) {
	List<Food> ord=osi.getCartItems(uid);
//	if(ord==null) {
//		throw new RuntimeException("userNotFound");
//		
//	}
	return  ord;
	
}
@DeleteMapping("/deleteorder/{oid}")
public List<Orders> deleteFood(@PathVariable int oid)
{
	Orders ord = osi.findById(oid);
	osi.deletebyId(oid);
	return osi.findAll();
}
@DeleteMapping("/deleteorder/{pid}/{uid}/{position}")
public List<Food> deleteFood(@PathVariable int pid,@PathVariable int uid,@PathVariable int position)
{
   osi.findcartitem(pid, uid, position);
	return osi.getCartItems(uid);
}
@PutMapping("/reduceQuantity")
public List<Orders> reduceQuantity(@RequestBody Orders order){
	osi.reduceQuantity(order);
	return osi.findAll();
}

@PutMapping("/increaseQuantity")
public List<Orders> increaseQuantity(@RequestBody Orders order){
//	System.out.println("nothing");
//	osi.presentincart(order);
////	boolean found  =osi.presentincart(order);
////	if(!found) {
////	System.out.println("Product being added is not is user cart");
//		order.setOid(0);
//		order.setQuantity1(1);
//		osi.save(order);
		
//	}
	osi.presentincart(order);

	return osi.findAll();
	
}
@GetMapping("/usercart/{uid}")
public List<Orders> getUserCart(@PathVariable int uid){
	return osi.getUserCart(uid);
}

}

