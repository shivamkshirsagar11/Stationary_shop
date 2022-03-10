package com.stationary.jdbc;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.stationary.Items.Desk;

public class DeskDao implements CommonInterfaceDao<Desk>{
	private HibernateTemplate ht;
	
	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public int insertObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObj(Desk p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Desk getOneObj(Desk p) {
		// TODO Auto-generated method stub
		return null;
	}

}
