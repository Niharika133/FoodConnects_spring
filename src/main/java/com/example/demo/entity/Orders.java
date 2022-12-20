package com.example.demo.entity;
//import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")

public class Orders {
	@Id //to recognize primarykey
	@GeneratedValue(strategy=GenerationType.IDENTITY)//identify auto increment
	@Column( name="oid")
private int oid;
	@Column( name="fid")
private int fid;
	@Column( name="uid")
private int uid;
	@Column( name="fname")
    private String fname;
	@Column( name="quantity1")
	private int quantity1;
	@ManyToOne(targetEntity=Food.class,fetch = FetchType.EAGER) 
	//manyemployees--onedept  (m-o)
	@JoinColumn(name="fid",insertable = false, updatable = false)
	private Food fd;
	
	@ManyToOne(targetEntity=User.class,fetch = FetchType.EAGER) 
	//manyemployees--onedept  (m-o)
	@JoinColumn(name="uid",insertable = false, updatable = false)
	private User us;
	
public Orders() {

}
public Orders(int oid, int fid, int uid,String fname,int quantity1) {
	this.oid = oid;
	this.fid = fid;
	this.uid = uid;
	this.fname=fname;
	this.quantity1=quantity1;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}

public int getQuantity1() {
	return quantity1;
}
public void setQuantity1(int quantity1) {
	this.quantity1 = quantity1;
}
@Override
public String toString() {
	return "Orders [oid=" + oid + ", fid=" + fid + ", uid=" + uid + ", fname=" + fname + ", quantity1=" + quantity1
			+ ", fd=" + fd + ", us=" + us + "]";
}

}




