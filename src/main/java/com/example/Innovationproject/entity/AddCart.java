package com.example.Innovationproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slno;
	private String username;
	private int itemserialid;
	public long getSlno() {
		return slno;
	}
	public void setSlno(long slno) {
		this.slno = slno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getItemserialid() {
		return itemserialid;
	}
	public void setItemserialid(int itemserialid) {
		this.itemserialid = itemserialid;
	}
	public AddCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCart(long slno, String username, int itemserialid) {
		super();
		this.slno = slno;
		this.username = username;
		this.itemserialid = itemserialid;
	}
	@Override
	public String toString() {
		return "AddCart [slno=" + slno + ", username=" + username + ", itemserialid=" + itemserialid + "]";
	}
	
	
	
	
}
