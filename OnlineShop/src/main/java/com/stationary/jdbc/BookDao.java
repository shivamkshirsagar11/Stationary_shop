package com.stationary.jdbc;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Book;

public class BookDao implements CommonInterfaceDao<Book>{
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public int insertObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book getOneObj(Book p) {
		// TODO Auto-generated method stub
		return null;
	}

}
