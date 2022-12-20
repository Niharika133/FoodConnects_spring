package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Food;
import com.example.demo.entity.FoodCategory;
import com.example.demo.entity.Orders;
import com.example.demo.entity.User;
import com.example.demo.persistance.FoodJpa;
import com.example.demo.persistance.OrdersJpa;
import com.example.demo.persistance.UserJpa;
@Service
public class OrdersServiceImp implements OrdersService{
private OrdersJpa obj;
private UserJpa ujp;
private FoodServiceImp fsi;
private FoodJpa fjp;


@Autowired
	public OrdersServiceImp(OrdersJpa obj,UserJpa ujp,FoodServiceImp fsi,FoodJpa fjp) {
	this.obj = obj;
	this.fsi=fsi;
	this.ujp=ujp;
	this.fjp=fjp;
}

	@Override
	@Transactional
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return obj.findAll();
	}

	@Override
	@Transactional
	public void save(Orders order) {
	
			// TODO Auto-generated method stub
			obj.save(order);
			
		}

	@Override
	@Transactional
	public Orders findById(int uid) {
		// TODO Auto-generated method stub
		return obj.findById(uid).get();
	}

	@Transactional
	public List<Food> getCartItems(int uid) {
		List<Orders> order = obj.findAll();
		Orders o = new Orders();
		List<Orders> usercart = new ArrayList<Orders>();
		for(int i = 0; i < order.size(); i++) {
			o = order.get(i);
			if(uid == o.getUid()) {
				usercart.add(o);
			}
		}
		order= null;
		Food f = new Food();
		List<Food> cartProducts = new ArrayList<Food>();
		boolean flag = true;
		int i = 0;
		while(flag) {
			if(i < usercart.size()) {
				o = usercart.get(i);
				f = fsi.findById(o.getFid());
				cartProducts.add(f);
				i=i+1;
			}
			if(i==usercart.size()) {
				flag = false;
			}
		}
		return cartProducts;
	}
	@Override
	@Transactional
	public void deletebyId(int oid) {
		// TODO Auto-generated method stub
		obj.deleteById(oid);
	}
	public void findcartitem(int fid,int uid,int position) {
		List<Orders> ord=obj.findAll();
		Orders o=new Orders();
		List<Orders> usercart=new ArrayList<Orders>();
		for(int i=0;i<ord.size();i++) {
			o=ord.get(i);
			if(uid==o.getUid()) {
				usercart.add(o);
			}
			
		}
		o=usercart.get(position);
		this.deletebyId(o.getOid());
	
 	}
	public void reduceQuantity(Orders order) {
		List<Orders> order1 = obj.findAll();
		List<Food> food =  this.getCartItems(order.getUid());
		Orders o = new Orders();
		int quantity1 = 0;
		for(int i = 0; i < food.size(); i++) {
			if(food.get(i).getFid() == order.getFid()) {
				//for(int j = 0;j < carts.size();j++) {
					//if(cart.getUid() == carts.get(j).getUid()) {
						order.setOid(order1.get(i).getOid());
						order.setQuantity1(order1.get(i).getQuantity1());
						
						//c = carts.get(j);
						quantity1 = order.getQuantity1();
						order.setQuantity1(--quantity1);
						obj.save(order);
						
					//}
				//}
			}
		}
	}

	public boolean presentincart(Orders order) {
		List<Orders> order1 = obj.findAll();
		List<Food> food =  this.getCartItems(order.getUid());
		Orders o = new Orders();
		int quantity1 = 0;
		for(int i = 0; i < food.size(); i++) {
			if(food.get(i).getFid() == order.getFid()) {
				//for(int j = 0;j < carts.size();j++) {
					//if(cart.getUid() == carts.get(j).getUid()) {
						order.setOid(order1.get(i).getOid());
						order.setQuantity1(order1.get(i).getQuantity1());
						
						//c = carts.get(j);
						quantity1 = order.getQuantity1();
						order.setQuantity1(++quantity1);
						obj.save(order);
						return true;
						
					//}
				//}
			}
		}
		return false;
		
		
		
		
		// TODO Auto-generated method stu
//		List<Orders> carts = obj.findAll();
//		System.out.println(carts.toString());
//		 List<Food> food =  this.getCartItems(order.getUid());
//		System.out.println(food.toString());
//		Orders o = new Orders();
//		int quantity1;
//		for(int i = 0; i < food.size(); i++) {
//			if(food.get(i).getFid() == order.getFid()) {
//				System.out.println("fid of product being added:"+order.getFid());
//				
//				//for(int j = 0;j < carts.size();j++) {
//					//if(cart.getUid() == carts.get(j).getUid()) {
//						order.setOid(carts.get(i).getOid());
//						order.setQuantity1(carts.get(i).getQuantity1());
//						//c = carts.get(j);
//						//System.out.println(c.toString());
//						quantity1 = order.getQuantity1();
//						order.setQuantity1(++quantity1);
//						obj.save(order);
//						System.out.println(obj.findAll().toString());
//						return true;
//					//}
//				//}
//			}
//		}
//		return false;
		
	}
	public List<Orders> getUserCart(int uid) {
		List<Orders> carts = obj.findAll();
		List<Orders> usercart = new ArrayList<Orders>();
		for(int i = 0;i < carts.size(); i++) {
			if(carts.get(i).getUid() == uid) {
				usercart.add(carts.get(i));
			}
		}
		return usercart;
	}
	
	}
	



