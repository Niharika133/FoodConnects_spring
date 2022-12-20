package com.example.demo.entity;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	@Id //to recognize primarykey
	@GeneratedValue(strategy=GenerationType.IDENTITY)//identify auto increment
	@Column( name="fid")
	private int fid;
	@Column( name="fname")
	private String fname;
	@Column( name="fprice")
	private  float fprice;
	@Column( name="fdesc")
	private String fdesc;
	@Column( name="fcid")
	private int fcid;
	@Column( name="fimg")
	private String fimg;
	


	@Column( name="quantity")
	private int quantity;
	
	@ManyToOne(targetEntity=FoodCategory.class,fetch = FetchType.EAGER) 
	//manyemployees--onedept  (m-o)
	@JoinColumn(name="fcid",insertable = false, updatable = false)
	private FoodCategory fc;

	@OneToMany(mappedBy = "fd")  //onedept---manyemployees  (o-m)  
	private Set<Orders>
	ord;
	
	
	public Food() {

	}


	public Food(int fid, String fname, float fprice, String fdesc, int fcid, String fimg, FoodCategory fc,
			Set<Orders> ord,int quantity) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fprice = fprice;
		this.fdesc = fdesc;
		this.fcid = fcid;
		this.fimg = fimg;
		this.fc = fc;
		this.ord = ord;
		this.quantity= quantity;
	}
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public float getFprice() {
		return fprice;
	}


	public void setFprice(float fprice) {
		this.fprice = fprice;
	}


	public String getFdesc() {
		return fdesc;
	}


	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}


	public int getFcid() {
		return fcid;
	}


	public void setFcid(int fcid) {
		this.fcid = fcid;
	}


	public String getFimg() {
		return fimg;
	}


	public void setFimg(String fimg) {
		this.fimg = fimg;
	}


	public FoodCategory getFc() {
		return fc;
	}


	public void setFc(FoodCategory fc) {
		this.fc = fc;
	}


	public Set<Orders> getOrd() {
		return ord;
	}


	public void setOrd(Set<Orders> ord) {
		this.ord = ord;
	}


	@Override
	public String toString() {
		return "Food [fid=" + fid + ", fname=" + fname + ", fprice=" + fprice + ", fdesc=" + fdesc + ", fcid=" + fcid
				+ ", fimg=" + fimg + ", quantity=" + quantity + ", fc=" + fc + ", ord=" + ord + "]";
	}


	
}