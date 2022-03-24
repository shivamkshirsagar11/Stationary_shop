package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Pen;

@Repository
public class PenDao{
	
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
	public int insertObj(Pen p) {
		// TODO Auto-generated method stub
		ht.save(p);
		return 1;
	}


	public int deleteObj(Pen p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}


	public int updateObj(Pen p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Pen getOneObj(int id) {
		// TODO Auto-generated method stub
		Pen pen = this.ht.get(Pen.class, id);
		return pen;
	}
	
	public List<Pen> getall()
	{
		return this.ht.loadAll(Pen.class);
	}
	
	public int minusStock(String itemId,int change) {
		try {
			String q = "update Pen set stock = stock-? where id = ?";
			return jt.update(q,change,itemId);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
	
	public int plusStock(String itemId,int change) {
		try {
			String q = "update Pen set stock = stock+? where id = ?";
			return jt.update(q,change,itemId);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return 0;
		}
	}
}