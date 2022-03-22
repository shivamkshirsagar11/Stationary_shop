package com.stationary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartGenerator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cartGenerationDate;
	private int userId;
	public CartGenerator(int id, String cartGenerationDate, int userId) {
		super();
		this.id = id;
		this.cartGenerationDate = cartGenerationDate;
		this.userId = userId;
	}

	public String getCartGenerationDate() {
		return cartGenerationDate;
	}

	public void setCartGenerationDate(String cartGenerationDate) {
		this.cartGenerationDate = cartGenerationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CartGenerator [id=" + id + ", cartGenerationDate=" + cartGenerationDate + ", userId=" + userId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CartGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
