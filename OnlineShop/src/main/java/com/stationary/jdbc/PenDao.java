package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Pen;

@Repository
public class PenDao{
	
	@Autowired
	private HibernateTemplate ht;

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

}