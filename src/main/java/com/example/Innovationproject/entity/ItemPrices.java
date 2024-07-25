package com.example.Innovationproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemPrices {

	@Id
	private int itemserial;
	@Column(nullable = false)
	private String itemname;
	@Column(nullable = false)
	private double cost;
	public int getItemserial() {
		return itemserial;
	}
	public void setItemserial(int itemserial) {
		this.itemserial = itemserial;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ItemPrices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemPrices(int itemserial, String itemname, double cost) {
		super();
		this.itemserial = itemserial;
		this.itemname = itemname;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "ItemPrices [itemserial=" + itemserial + ", itemname=" + itemname + ", cost=" + cost + "]";
	}
	
	
}
