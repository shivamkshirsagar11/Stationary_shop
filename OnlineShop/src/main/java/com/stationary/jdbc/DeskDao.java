package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Desk;

@Repository
public class DeskDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	
	@Transactional
	public int insertObj(Desk p) {
		// TODO Auto-generated method stub
		this.ht.save(p);
		return 1;
	}

	
	public int deleteObj(Desk p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	
	public int updateObj(Desk p) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	public List<Desk> getall()
	{
		return this.ht.loadAll(Desk.class);
	}
	
	public Desk getOneObj(int id) {
		// TODO Auto-generated method stub
		Desk d = this.ht.get(Desk.class, id);
		return d;
	}

}