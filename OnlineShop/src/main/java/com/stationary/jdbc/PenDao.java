package com.stationary.jdbc;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Pen;

public class PenDao implements CommonInterfaceDao<Pen>{
	private HibernateTemplate ht;
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public int insertObj(Pen p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Pen p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObj(Pen p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pen getOneObj(Pen p) {
		// TODO Auto-generated method stub
		return null;
	}

}
