package com.example.demo.entity;
import java.util.List;
//import java.util.Set;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="foodcategory")
public class FoodCategory {
	@Id //to recognize primarykey
	@GeneratedValue(strategy=GenerationType.IDENTITY)//identify auto increment
	@Column( name="fcid")
	private int fcid;
	@Column( name="fcname")
	private String fcname;
	
	@OneToMany(mappedBy = "fc")  //onedept---manyemployees  (o-m)  
	private List<Food>//Set<Food>
	fcm;
	
	



	public FoodCategory() {
	}


	public FoodCategory(int fcid, String fcname) {

		this.fcid = fcid;
		this.fcname = fcname;
	
	}


	public int getFcid() {
		return fcid;
	}


	public void setFcid(int fcid) {
		this.fcid = fcid;
	}


	public String getFcname() {
		return fcname;
	}


	public void setFcname(String fcname) {
		this.fcname = fcname;
	}


	@Override
	public String toString() {
		return "FoodCategory [fcid=" + fcid + ", fcname=" + fcname +  "]";
	}

}


