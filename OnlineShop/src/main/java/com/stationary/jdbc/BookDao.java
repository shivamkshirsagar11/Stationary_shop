package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Book;


@Repository
public class BookDao{
	
	@Autowired
	private HibernateTemplate ht;
	@Autowired
	private JdbcTemplate jt;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Transactional
	public int insertObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.save(p);
		return 1;
	}

	@Transactional
	public int deleteObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	
	@Transactional
	public int updateObj(Book p) {
		// TODO Auto-generated method stub
		this.ht.update(p);
		return 1;
	}

	
	public Book getOneObj(int id) {
		// TODO Auto-generated method stub
		Book b = ht.get(Book.class, id);
		return b;
	}
	
	
	
	public int plusStock(String itemId,int change) {
		try {
			String q = "update Book set stock = stock+? where id = ?";
			return jt.update(q,change,itemId);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
	
	public int minusStock(String itemId,int change) {
		try {
			String q = "update Book set stock = stock-? where id = ?";
			return jt.update(q,change,itemId);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
	
	public List<Book> getall()
	{
		return this.ht.loadAll(Book.class);
	}
}