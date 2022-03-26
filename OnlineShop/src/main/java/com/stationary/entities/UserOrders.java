package com.stationary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class UserOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public UserOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String orderingDate;
	@Column(unique=true)
	private String orderId;
	private int userId;
	@Column(unique=true)
	private int cartId;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@OneToMany
	private List<UserCart> ordersPerBatch;
	
	private int total;
	public List<UserCart> getOrdersPerBatch() {
		return ordersPerBatch;
	}
	public void setOrdersPerBatch(List<UserCart> ordersPerBatch) {
		this.ordersPerBatch = ordersPerBatch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderingDate() {
		return orderingDate;
	}
	public void setOrderingDate(String orderingDate) {
		this.orderingDate = orderingDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId,boolean val) {
		if(val)
		this.orderId = "Ord_ID#1568_Batch#"+orderId;
		else this.orderId = orderId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void calculateTotal() {
		int temp = 0;
		for(UserCart i:ordersPerBatch) {
			temp  += i.getItemCount() * i.getItemPrice();
		}
		this.total = temp;
	}
}
