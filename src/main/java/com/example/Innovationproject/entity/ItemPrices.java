package com.example.Innovationproject.entity;

import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonEncoding;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class ItemPrices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemserial;
	@Column(nullable = false)
	private String itemname;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private double quantity;
	
	private String imagename;
	private String imageType;
	@Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] imgData;
	@JsonFormat(pattern = "dd-MM-yyyy",shape = Shape.STRING)
	private LocalDate date;
	
	@Column(nullable = false)
	private String discription;
	
	@Column(nullable = false)
	private String itemType;
	
	
	
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImgData() {
		return imgData;
	}

	public void setImgData(byte[] imgData) {
		this.imgData = imgData;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	
	
	public ItemPrices() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ItemPrices(int itemserial, String itemname, double cost, double quantity, String imagename, String imageType,
			byte[] imgData, LocalDate date, String discription, String itemType, String encodedImage) {
		super();
		this.itemserial = itemserial;
		this.itemname = itemname;
		this.cost = cost;
		this.quantity = quantity;
		this.imagename = imagename;
		this.imageType = imageType;
		this.imgData = imgData;
		this.date = date;
		this.discription = discription;
		this.itemType = itemType;
		this.encodedImage = encodedImage;
	}



	@Override
	public String toString() {
		return "ItemPrices [itemserial=" + itemserial + ", itemname=" + itemname + ", cost=" + cost + ", quantity="
				+ quantity + ", imagename=" + imagename + ", imageType=" + imageType + ", imgData="
				+ Arrays.toString(imgData) + ", date=" + date + ", discription=" + discription + ", itemType="
				+ itemType + ", encodedImage=" + encodedImage + "]";
	}



	@Transient
    private String encodedImage;
	 public String getEncodedImage() {
	        return encodedImage;
	    }

	    public void setEncodedImage(String encodedImage) {
	        this.encodedImage = encodedImage;
	    }
	
}
