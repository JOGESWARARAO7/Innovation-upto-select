package com.example.Innovationproject.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userid;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false,unique = true)
	private String emailid;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false,unique = true)
	private long phoneno;
	@Column(nullable = false)
	private LocalDate dob;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private long pincode;
	@Column(nullable = false,unique = true)
	private String username;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(long userid, String firstname, String lastname, String emailid, String password, long phoneno,
			LocalDate dob, String address, String city, long pincode, String username) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.phoneno = phoneno;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserData [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", password=" + password + ", phoneno=" + phoneno + ", dob=" + dob + ", address=" + address
				+ ", city=" + city + ", pincode=" + pincode + ", username=" + username + "]";
	}
	
	
	
	
}
