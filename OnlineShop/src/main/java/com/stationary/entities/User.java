package com.stationary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String password;
	private String mobile;
	private String email;
	private String lastLogin;
	private Address address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String name, String password, String mobile, String email,
			String lastLogin, Address address) {
		super();
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.lastLogin = lastLogin;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", email="
				+ email + ", lastLogin=" + lastLogin + ", address=" + address + "]";
	}
	
}
