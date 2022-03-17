package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Book;


@Repository
public class BookDao{
	
	@Autowired
	HibernateTemplate ht;
	
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

	
	public int updateObj(Book p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Book getOneObj(int id) {
		// TODO Auto-generated method stub
		Book b = ht.get(Book.class, id);
		return b;
	}
	
	public List<Book> getall()
	{
		return this.ht.loadAll(Book.class);
	}
}