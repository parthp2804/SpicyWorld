package au.com.spicyworld.model;

import java.text.DateFormat;
import java.util.Random; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String firstname;
	private String lastname;
	private String address;
	private String mobileno;
	private String emailid;
	private String pickdate;
	private String picktime;
	private int order_ID;
	
	//getter setter
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	} 
	public int getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID() {
		Random rand = new Random();
		int rand_int = rand.nextInt(100000); 
		this.order_ID = rand_int;
	}
	public String getPickdate() {
		return pickdate;
	}
	public void setPickdate(String pickdate) {
		this.pickdate = pickdate;
	}
	public String getPicktime() {
		return picktime;
	}
	public void setPicktime(String picktime) {
		this.picktime = picktime;
	}
	
}
