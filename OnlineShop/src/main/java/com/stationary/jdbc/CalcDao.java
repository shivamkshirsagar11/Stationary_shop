package com.stationary.jdbc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.Items.Calc;

@Repository
public class CalcDao{

	@Autowired
	private HibernateTemplate ht;
	
	
	@Transactional
	public int insertObj(Calc p) {
		// TODO Auto-generated method stub
		ht.save(p);
		return 1;
	}

	
	public int deleteObj(Calc p) {
		// TODO Auto-generated method stub
		this.ht.delete(p);
		return 0;
	}

	
	public int updateObj(Calc p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Calc getOneObj(int id) {
		// TODO Auto-generated method stub
		Calc c = ht.get(Calc.class, id);
		return c;
	}
	
	public List<Calc> getall()
	{
		return this.ht.loadAll(Calc.class);
	}
}