package com.example.demo.entity;
import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id //to recognize primarykey
	@GeneratedValue(strategy=GenerationType.IDENTITY)//identify auto increment
	@Column( name="uid")
 private int uid;
	@Column( name="uname")
 private String uname;
	@Column( name="uemail")
 private String uemail;
	@Column( name="uaddress")
 private String uaddress;
	@Column( name="upass")
 private String upass;
	@Column( name="uphone")
 private Long uphone;
	
	@OneToMany(mappedBy = "us") 
	private Set<Orders> 
	os;
		
public User() {
}
public User(int uid, String uname, String uemail, String uaddress, String upass, Long uphone) {
	
	this.uid = uid;
	this.uname = uname;
	this.uemail = uemail;
	this.uaddress = uaddress;
	this.upass = upass;
	this.uphone = uphone;
}

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}

public String getUaddress() {
	return uaddress;
}

public void setUaddress(String uaddress) {
	this.uaddress = uaddress;
}

public String getUpass() {
	return upass;
}

public void setUpass(String upass) {
	this.upass = upass;
}

public Long getUphone() {
	return uphone;
}

public void setUphone(Long uphone) {
	this.uphone = uphone;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", uaddress=" + uaddress + ", upass="
			+ upass + ", uphone=" + uphone + "]";
}


}



