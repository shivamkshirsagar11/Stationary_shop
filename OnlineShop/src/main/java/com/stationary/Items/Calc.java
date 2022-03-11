package com.stationary.Items;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Calc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productTableId;
	
	public int getProductTableId() {
		return productTableId;
	}

	public void setProductTableId(int productTableId) {
		this.productTableId = productTableId;
	}

	private String id;
	private String name;
	private String des;
	private String compName;
	private int price;
	private int stock;
	private String type;
	private byte[] image;

	public Calc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calc(String id, String name, String des, String compName, int price, int stock, String type,
			byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.compName = compName;
		this.price = price;
		this.stock = stock;
		this.type = type;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Calc [pId=" + id + ", pName=" + name + ", des=" + des + ", compName=" + compName + ", price=" + price
				+ ", stock=" + stock + ", type=" + type + ", image=" + Arrays.toString(image) + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String pId) {
		this.id = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}