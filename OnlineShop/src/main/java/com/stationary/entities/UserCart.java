package com.stationary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int userId;
	private int cartId;
	private String dateAndTime;
	private String itemName;
	private String itemId;
	private int itemPrice;
	private int itemCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public UserCart(int id, int userId, int cartId, String dateAndTime, String itemName, String itemId,
			int itemPrice, int itemCount) {
		super();
		this.id = id;
		this.userId = userId;
		this.cartId = cartId;
		this.dateAndTime = dateAndTime;
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.itemCount = itemCount;
	}
	public UserCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserCart [id=" + id + ", userId=" + userId + ", cartId=" + cartId + ", dateAndTime=" + dateAndTime
				+ ", itemName=" + itemName + ", itemId=" + itemId + ", itemPrice=" + itemPrice + ", itemCount="
				+ itemCount + "]";
	}
	
}
