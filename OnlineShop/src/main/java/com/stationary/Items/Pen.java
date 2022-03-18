package com.stationary.Items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productTableId;
	
	private String id;
	private String name;
	private String des;
	private String compName;
	private int price;
	private int stock;
	private String color;
	private String image;

	
	public int getProductTableId() {
		return productTableId;
	}

	public void setProductTableId(int productTableId) {
		this.productTableId = productTableId;
	}

	public Pen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pen(String pId, String pName, String des, String compName, int price, int stock, String color,
			String image) {
		super();
		this.id = pId;
		this.name = pName;
		this.des = des;
		this.compName = compName;
		this.price = price;
		this.stock = stock;
		this.color = color;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Pen [pId=" + id + ", pName=" + name + ", des=" + des + ", compName=" + compName + ", price=" + price
				+ ", stock=" + stock + ", color=" + color + ", image=" + image + "]";
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}