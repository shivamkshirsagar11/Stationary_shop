package com.stationary.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Book;

public class BookDao{
	private HibernateTemplate ht;
	private JdbcTemplate jt;
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	
	public int insertObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int deleteObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Book getOneObj(Book p) {
		// TODO Auto-generated method stub
		return null;
	}

}
